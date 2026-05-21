package com.locker.be.app.kiosk.service;

import com.locker.be.app.kiosk.dto.KioskAuthDto;
import com.locker.be.app.kiosk.dto.KioskAuthQueryDto;
import com.locker.be.app.kiosk.mapper.KioskAuthMapper;
import com.locker.be.web.user.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
public class KioskAuthService {

    private final KioskAuthMapper kioskAuthMapper;
    private final JwtUtil jwtUtil;

    public String create(KioskAuthDto.KioskAuthCreateReq dto) {
        kioskAuthMapper.create(dto);
        return dto.getAUTH_CODE();
    }

    public void update(KioskAuthDto.KioskAuthUpdateReq dto, String token) {
        Long userId = jwtUtil.getUserId(token);

        KioskAuthDto.KioskAuthUpdateReq params = KioskAuthDto.KioskAuthUpdateReq.builder()
                .AUTH_CODE(dto.getAUTH_CODE())
                .USER_ID(userId)
                .build();

        kioskAuthMapper.update(params);
    }

    // @Transactional(readOnly = true)
    public Collection<KioskAuthQueryDto.KioskAuthRes> findAuth(KioskAuthQueryDto.KioskAuthReq dto) {

        return kioskAuthMapper.findAuth(dto);
    }

}
