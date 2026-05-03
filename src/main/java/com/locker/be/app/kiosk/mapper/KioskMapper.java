package com.locker.be.app.kiosk.mapper;

import com.locker.be.app.kiosk.dto.KioskQueryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

@Mapper
public interface KioskMapper {

    public Collection<KioskQueryDto.KioskInfoRes> kioskLogin(KioskQueryDto.KioskLoginReq dto);
}
