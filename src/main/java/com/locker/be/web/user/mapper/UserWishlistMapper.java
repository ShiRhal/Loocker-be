package com.locker.be.web.user.mapper;

import com.locker.be.web.user.dto.UserWishlistDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserWishlistMapper {

    public void save(UserWishlistDto.UserWishlistSaveReq dto);

}
