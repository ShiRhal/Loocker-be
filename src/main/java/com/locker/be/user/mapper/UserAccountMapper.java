package com.locker.be.user.mapper;

import com.locker.be.user.dto.UserAccountDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

@Mapper
public interface UserAccountMapper {

    public void create(UserAccountDto.UserAccountCreateReq dto);

    public void update(UserAccountDto.UserAccountUpdateReq dto);

    public void delete(UserAccountDto.UserAccountDeleteReq dto);

}
