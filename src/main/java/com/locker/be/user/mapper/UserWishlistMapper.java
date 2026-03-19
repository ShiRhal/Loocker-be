package com.locker.be.user.mapper;

import com.locker.be.user.dto.UserWishlistDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserWishlistMapper {

    public void save(UserWishlistDto.UserWishlistSaveReq dto);

}
