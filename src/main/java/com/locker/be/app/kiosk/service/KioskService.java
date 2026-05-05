package com.locker.be.app.kiosk.service;

import com.locker.be.app.kiosk.dto.KioskQueryDto;
import com.locker.be.app.kiosk.mapper.KioskMapper;
import com.locker.be.web.user.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
public class KioskService {

    private final KioskMapper kioskMapper;
    private final JwtUtil jwtUtil;

    public Collection<KioskQueryDto.KioskInfoRes> kioskLogin(KioskQueryDto.KioskLoginReq dto) {
        Collection<KioskQueryDto.KioskInfoRes> result = kioskMapper.kioskLogin(dto);

        for (KioskQueryDto.KioskInfoRes kiosk : result) {
            String token = jwtUtil.createKioskAccessToken(kiosk.getLOGIN_ID());
            kiosk.setKIOSK_ACCESS_TOKEN(token);
        }

        return result;
    }
}