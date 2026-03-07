package com.locker.be.user.service;

import com.locker.be.user.dto.UserDto;
import com.locker.be.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private UserMapper userMapper;

    public void update(UserDto.UserUpdateReq dto) {
        userMapper.update(dto);
    }

    public void banned(UserDto.UserBannedReq dto) {
        userMapper.banned(dto);
    }

    public void delete(UserDto.UserDeleteReq dto) {
        userMapper.delete(dto);
    }
}
