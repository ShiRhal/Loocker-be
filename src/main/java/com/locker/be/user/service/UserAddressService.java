package com.locker.be.user.service;

import com.locker.be.user.dto.UserAddressDto;
import com.locker.be.user.mapper.UserAddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserAddressService {

    private final UserAddressMapper userAddressMapper;

    public void create(UserAddressDto.UserAddressCreateReq dto) {
        userAddressMapper.create(dto);
    }

    public void update(UserAddressDto.UserAddressUpdateReq dto) {
        userAddressMapper.update(dto);
    }

    public void delete(UserAddressDto.UserAddressDeleteReq dto) {
        userAddressMapper.delete(dto);
    }

}
