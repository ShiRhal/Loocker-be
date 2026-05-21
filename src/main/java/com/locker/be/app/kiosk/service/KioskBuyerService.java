package com.locker.be.app.kiosk.service;

import com.locker.be.app.kiosk.dto.KioskBuyerQueryDto;
import com.locker.be.app.kiosk.mapper.KioskBuyerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
public class KioskBuyerService {

    private final KioskBuyerMapper kioskBuyerMapper;

    // @Transactional(readOnly = true)
    public Collection<KioskBuyerQueryDto.KioskLockerRes> lockerListBuyer(KioskBuyerQueryDto.KioskLockerReq dto) {

        return kioskBuyerMapper.lockerListBuyer(dto);
    }

    // @Transactional(readOnly = true)
    public Collection<KioskBuyerQueryDto.KioskProductRes> productListBuyer(KioskBuyerQueryDto.KioskProductReq dto) {

        return kioskBuyerMapper.productListBuyer(dto);
    }
}
