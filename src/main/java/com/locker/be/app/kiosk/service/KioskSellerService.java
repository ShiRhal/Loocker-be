package com.locker.be.app.kiosk.service;

import com.locker.be.app.kiosk.dto.KioskSellerQueryDto;
import com.locker.be.app.kiosk.mapper.KioskSellerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
public class KioskSellerService {

    private final KioskSellerMapper kioskSellerMapper;

    // @Transactional(readOnly = true)
    public Collection<KioskSellerQueryDto.KioskLockerRes> lockerListSeller(KioskSellerQueryDto.KioskLockerReq dto) {

        return kioskSellerMapper.lockerListSeller(dto);
    }

    // @Transactional(readOnly = true)
    public Collection<KioskSellerQueryDto.KioskProductRes> productListSeller(KioskSellerQueryDto.KioskProductReq dto) {

        return kioskSellerMapper.productListSeller(dto);
    }
}
