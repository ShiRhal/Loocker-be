package com.locker.be.app.locker.mapper;

import com.locker.be.app.locker.dto.LockerPayDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LockerPayMapper {

    public void create(LockerPayDto.LockerPayCreateReq dto);

    public void paid(LockerPayDto.LockerPayUpdateReq dto);
}
