package com.locker.be.app.locker.service;

import com.locker.be.app.locker.dto.LockerDto;
import com.locker.be.app.locker.mapper.LockerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.time.Instant;

@Slf4j
@Service
@Transactional
public class LockerService {

    private final LockerMapper lockerMapper;
    private final TaskScheduler taskScheduler;

    public LockerService(
            LockerMapper lockerMapper,
            @Qualifier("appTaskScheduler") TaskScheduler taskScheduler
    ) {
        this.lockerMapper = lockerMapper;
        this.taskScheduler = taskScheduler;
    }

    public String update(LockerDto.LockerUpdateReq dto) {
        lockerMapper.update(dto);

        String resultStatusCode = dto.getRESULT_STATUS_CODE();

        if ("PICKUP_LOCKED_EMPTY_READY".equals(resultStatusCode)) {
            Long tradeId = dto.getTRADE_ID();

            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
                @Override
                public void afterCommit() {
                    taskScheduler.schedule(
                            () -> resetLockerToEmpty(tradeId),
                            Instant.now().plusSeconds(5)
                    );
                }
            });
        }

        return resultStatusCode;
    }

    private void resetLockerToEmpty(Long tradeId) {
        try {
            LockerDto.LockerUpdateReq resetDto = LockerDto.LockerUpdateReq.builder()
                    .TRADE_ID(tradeId)
                    .AUTH_CODE(null)
                    .NEXT_STATUS("EMPTY")
                    .ROLE_TYPE("DEVICE")
                    .RESULT_STATUS_CODE("")
                    .build();

            lockerMapper.update(resetDto);

            log.info("보관함 EMPTY 초기화 완료 tradeId={}, result={}",
                    tradeId,
                    resetDto.getRESULT_STATUS_CODE());

        } catch (Exception e) {
            log.error("보관함 EMPTY 초기화 실패 tradeId={}", tradeId, e);
        }
    }
}