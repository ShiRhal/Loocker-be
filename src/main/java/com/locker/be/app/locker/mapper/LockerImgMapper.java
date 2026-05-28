package com.locker.be.app.locker.mapper;

import com.locker.be.app.locker.dto.LockerImgDto;
import com.locker.be.app.locker.dto.LockerImgQueryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

@Mapper
public interface LockerImgMapper {

    public void create(LockerImgDto.LockerImgCreateParam dto);

    public Collection<LockerImgQueryDto.LockerImgRes> findImg(LockerImgQueryDto.LockerImgReq dto);
}
