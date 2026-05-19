package com.locker.be.app.locker.mapper;

import com.locker.be.app.locker.dto.LockerDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LockerMapper {

    public void create(LockerDto.LockerCreateReq dto);

    public void update(LockerDto.LockerUpdateReq dto);
}
