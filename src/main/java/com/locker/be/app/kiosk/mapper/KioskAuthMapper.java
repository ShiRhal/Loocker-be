package com.locker.be.app.kiosk.mapper;

import com.locker.be.app.kiosk.dto.KioskAuthDto;
import com.locker.be.app.kiosk.dto.KioskAuthQueryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

@Mapper
public interface KioskAuthMapper {

    public Collection<KioskAuthQueryDto.KioskAuthRes> findAuth(KioskAuthQueryDto.KioskAuthReq dto);

    public void create(KioskAuthDto.KioskAuthCreateReq dto);

    public void update(KioskAuthDto.KioskAuthUpdateReq dto);
}
