package com.locker.be.app.locker.mapper;

import com.locker.be.app.locker.dto.LockerCmdDto;
import com.locker.be.app.locker.dto.LockerCmdQueryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

@Mapper
public interface LockerCmdMapper {

    public void create(LockerCmdDto.LockerCmdInsertReq dto);

    public void update(LockerCmdDto.LockerCmdUpdateReq dto);

    public Collection<LockerCmdQueryDto.LockerCmdRes> findCmd(LockerCmdQueryDto.LockerCmdReq dto);

    public Collection<LockerCmdQueryDto.LockerCmdStatusRes> findCmdStatus(LockerCmdQueryDto.LockerCmdStatusReq dto);

    public void adminCreate(LockerCmdDto.LockerAdminCmdInsertReq dto);
}
