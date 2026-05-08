package com.locker.be.web.trade.service;

import com.locker.be.web.trade.dto.TradeDto;
import com.locker.be.web.trade.mapper.TradeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class TradeDeliveryDemoService {

    private final TradeMapper tradeMapper;
    private final ThreadPoolTaskScheduler tradeTaskScheduler;

    private final Set<Long> runningTradeIds = ConcurrentHashMap.newKeySet();

    private static final List<String> DELIVERY_DEMO_STEPS = List.of(
            "ORDER_CHECK",   // 주문 확인
            "SHIPPING",      // 배송중
            "DELIVERED",     // 배송 완료
            "PICKEDUP"       // 택배 수령
    );

    public void start(Long tradeId) {
        if (tradeId == null) return;
        if (!runningTradeIds.add(tradeId)) {
            log.info("이미 택배 자동 시연이 진행 중입니다. tradeId={}", tradeId);
            return;
        }
        log.info("택배 자동 시연 시작. tradeId={}", tradeId);
        scheduleNext(tradeId, 0);
    }

    private void scheduleNext(Long tradeId, int stepIndex) {
        if (stepIndex >= DELIVERY_DEMO_STEPS.size()) {
            runningTradeIds.remove(tradeId);
            log.info("택배 자동 시연 종료. tradeId={}", tradeId);
            return;
        }
        tradeTaskScheduler.schedule(() -> {
            try {
                String nextStatusCode = DELIVERY_DEMO_STEPS.get(stepIndex);
                TradeDto.TradeUpdateReq params = TradeDto.TradeUpdateReq.builder()
                        .TRADE_ID(tradeId)
                        .USER_ID(null)
                        .NEXT_STATUS_CODE(nextStatusCode)
                         .TRADE_TYPE_CODE("DELIVERY")
                        .build();
                tradeMapper.update(params);
                log.info(
                        "택배 자동 상태 변경 완료. tradeId={}, nextStatusCode={}, resultStatusCode={}",
                        tradeId,
                        nextStatusCode,
                        params.getRESULT_STATUS_CODE()
                );
                scheduleNext(tradeId, stepIndex + 1);
            } catch (Exception e) {
                runningTradeIds.remove(tradeId);
                log.error("택배 자동 상태 변경 실패. tradeId={}", tradeId, e);
            }
        }, Instant.now().plusSeconds(10));
    }
}