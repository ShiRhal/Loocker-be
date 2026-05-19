package com.locker.be.app.kiosk.service;

import com.locker.be.app.kiosk.dto.KioskSellerQueryDto;
import com.locker.be.app.kiosk.mapper.KioskSellerMapper;
import com.locker.be.web.user.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
public class KioskSellerService {

    private final KioskSellerMapper kioskSellerMapper;
    private final JwtUtil jwtUtil;

    // @Transactional(readOnly = true)
    public Collection<KioskSellerQueryDto.KioskLockerRes> lockerListSeller(KioskSellerQueryDto.KioskLockerReq dto, String token) {
        Long userID = jwtUtil.getUserId(token);
        KioskSellerQueryDto.KioskLockerReq params = KioskSellerQueryDto.KioskLockerReq.builder()
                .USER_ID(userID)
                .PRODUCT_ID(dto.getPRODUCT_ID())
                .KIOSK_CODE(dto.getKIOSK_CODE())
                .build();
        return kioskSellerMapper.lockerListSeller(params);
    }

    // @Transactional(readOnly = true)
    public Collection<KioskSellerQueryDto.KioskProductRes> productListSeller(KioskSellerQueryDto.KioskProductReq dto, String token) {
        Long userID = jwtUtil.getUserId(token);
        KioskSellerQueryDto.KioskProductReq params = KioskSellerQueryDto.KioskProductReq.builder()
                .USER_ID(userID)
                .KIOSK_CODE(dto.getKIOSK_CODE())
                .build();
        return kioskSellerMapper.productListSeller(params);
    }
}
