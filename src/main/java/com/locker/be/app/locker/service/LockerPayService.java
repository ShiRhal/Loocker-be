package com.locker.be.app.locker.service;

import com.locker.be.app.locker.dto.LockerPayDto;
import com.locker.be.app.locker.mapper.LockerPayMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LockerPayService {

    private final LockerPayMapper lockerPayMapper;

    public void create(LockerPayDto.LockerPayCreateReq dto) {
        lockerPayMapper.create(dto);
    }

    public Long paid(LockerPayDto.LockerPayUpdateReq dto) {
        lockerPayMapper.paid(dto);
        return dto.getSUCCESS();
    }
}
