package com.locker.be.user.mapper;

import com.locker.be.user.dto.UserDto;
import com.locker.be.user.dto.UserQueryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

@Mapper
public interface UserMapper {

    public void update (UserDto.UserUpdateReq dto);

    public void banned (UserDto.UserBannedReq dto);

    public void delete (UserDto.UserDeleteReq dto);

    public Collection<UserQueryDto.UserProductRes> findPrd(UserQueryDto.UserInfoReq dto);

    public Collection<UserQueryDto.UserWishlistRes> findWish(UserQueryDto.UserInfoReq dto);

    public Collection<UserQueryDto.UserAccountRes> findAccount(UserQueryDto.UserInfoReq dto);

    public Collection<UserQueryDto.UserAddressRes> findAddress(UserQueryDto.UserInfoReq dto);

    public UserQueryDto.UserRes findUser(UserQueryDto.UserInfoReq dto);
}
