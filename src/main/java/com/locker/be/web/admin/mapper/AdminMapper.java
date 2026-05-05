package com.locker.be.web.admin.mapper;

import com.locker.be.web.admin.dto.AdminQueryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

@Mapper
public interface AdminMapper {

    public Collection<AdminQueryDto.AdminRes> login(AdminQueryDto.AdminReq dto);
}
