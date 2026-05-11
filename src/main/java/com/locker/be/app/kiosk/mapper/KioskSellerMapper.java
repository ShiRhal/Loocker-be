package com.locker.be.app.kiosk.mapper;

import com.locker.be.app.kiosk.dto.KioskSellerQueryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

@Mapper
public interface KioskSellerMapper {

    public Collection<KioskSellerQueryDto.KioskLockerRes> lockerList(KioskSellerQueryDto.KioskLockerReq dto);

    public Collection<KioskSellerQueryDto.KioskProductRes> productList(KioskSellerQueryDto.KioskProductReq dto);
}
