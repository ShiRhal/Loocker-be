package com.locker.be.app.kiosk.service;

import com.locker.be.app.kiosk.dto.KioskBuyerQueryDto;
import com.locker.be.app.kiosk.mapper.KioskBuyerMapper;
import com.locker.be.web.user.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
public class KioskBuyerService {

    private final KioskBuyerMapper kioskBuyerMapper;
    private final JwtUtil jwtUtil;

    // @Transactional(readOnly = true)
    public Collection<KioskBuyerQueryDto.KioskLockerRes> lockerListBuyer(KioskBuyerQueryDto.KioskLockerReq dto, String token) {
        Long userID = jwtUtil.getUserId(token);
        KioskBuyerQueryDto.KioskLockerReq params = KioskBuyerQueryDto.KioskLockerReq.builder()
                .USER_ID(userID)
                .TRADE_ID(dto.getTRADE_ID())
                .build();
        return kioskBuyerMapper.lockerListBuyer(params);
    }

    // @Transactional(readOnly = true)
    public Collection<KioskBuyerQueryDto.KioskProductRes> productListBuyer(KioskBuyerQueryDto.KioskProductReq dto, String token) {
        Long userID = jwtUtil.getUserId(token);
        KioskBuyerQueryDto.KioskProductReq params = KioskBuyerQueryDto.KioskProductReq.builder()
                .USER_ID(userID)
                .KIOSK_CODE(dto.getKIOSK_CODE())
                .build();
        return kioskBuyerMapper.productListBuyer(params);
    }
}
