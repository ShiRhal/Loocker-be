package com.locker.be.web.user.mapper;

import com.locker.be.web.user.dto.UserAddressDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAddressMapper {

    public void create(UserAddressDto.UserAddressCreateReq dto);

    public void update(UserAddressDto.UserAddressUpdateReq dto);

    public void delete(UserAddressDto.UserAddressDeleteReq dto);

}
