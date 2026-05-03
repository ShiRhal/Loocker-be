package com.locker.be.app.kiosk.service;

import com.locker.be.app.kiosk.dto.KioskQueryDto;
import com.locker.be.app.kiosk.mapper.KioskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
public class KioskService {

    private final KioskMapper kioskMapper;

    // @Transactional(readOnly = true)
    public Collection<KioskQueryDto.KioskInfoRes> kioskLogin(KioskQueryDto.KioskLoginReq dto) {

        return kioskMapper.kioskLogin(dto);
    }

}
