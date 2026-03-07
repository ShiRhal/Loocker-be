package com.locker.be.user.mapper;

import com.locker.be.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public void update (UserDto.UserUpdateReq dto);

    public void banned (UserDto.UserBannedReq dto);

    public void delete (UserDto.UserDeleteReq dto);
}
