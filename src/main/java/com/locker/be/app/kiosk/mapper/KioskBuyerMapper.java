package com.locker.be.app.kiosk.mapper;

import com.locker.be.app.kiosk.dto.KioskBuyerQueryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

@Mapper
public interface KioskBuyerMapper {

    public Collection<KioskBuyerQueryDto.KioskLockerRes> lockerListBuyer(KioskBuyerQueryDto.KioskLockerReq dto);

    public Collection<KioskBuyerQueryDto.KioskProductRes> productListBuyer(KioskBuyerQueryDto.KioskProductReq dto);
}
