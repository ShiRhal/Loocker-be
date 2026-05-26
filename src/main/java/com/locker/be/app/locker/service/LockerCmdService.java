package com.locker.be.app.locker.service;

import com.locker.be.app.locker.dto.LockerCmdDto;
import com.locker.be.app.locker.dto.LockerCmdQueryDto;
import com.locker.be.app.locker.mapper.LockerCmdMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
public class LockerCmdService {

    private final LockerCmdMapper lockerCmdMapper;

    public void create(LockerCmdDto.LockerCmdInsertReq dto) {
        lockerCmdMapper.create(dto);
    }

    public void update(LockerCmdDto.LockerCmdUpdateReq dto) {
        lockerCmdMapper.update(dto);
    }

    // @Transactional(readOnly = true)
    public Collection<LockerCmdQueryDto.LockerCmdRes> findCmd(LockerCmdQueryDto.LockerCmdReq dto) {

        return lockerCmdMapper.findCmd(dto);
    }

    // @Transactional(readOnly = true)
    public Collection<LockerCmdQueryDto.LockerCmdStatusRes> findCmdStatus(LockerCmdQueryDto.LockerCmdStatusReq dto) {

        return lockerCmdMapper.findCmdStatus(dto);
    }
}
