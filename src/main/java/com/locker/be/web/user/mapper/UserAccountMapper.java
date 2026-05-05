package com.locker.be.web.user.mapper;

import com.locker.be.web.user.dto.UserAccountDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAccountMapper {

    public void create(UserAccountDto.UserAccountCreateReq dto);

    public void update(UserAccountDto.UserAccountUpdateReq dto);

    public void delete(UserAccountDto.UserAccountDeleteReq dto);

}
