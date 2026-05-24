package com.locker.be.app.locker.service;

import com.locker.be.app.locker.dto.LockerDto;
import com.locker.be.app.locker.mapper.LockerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LockerService {

    private final LockerMapper lockerMapper;

    public String update (LockerDto.LockerUpdateReq dto) {
        lockerMapper.update(dto);
        return dto.getRESULT_STATUS_CODE();
    }

}
