package com.locker.be.web.user.service;

import com.locker.be.web.user.dto.UserAccountDto;
import com.locker.be.web.user.mapper.UserAccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserAccountService {

    private final UserAccountMapper userAccountMapper;

    public void create(UserAccountDto.UserAccountCreateReq dto) {
        userAccountMapper.create(dto);
    }

    public void update(UserAccountDto.UserAccountUpdateReq dto) {
        userAccountMapper.update(dto);
    }

    public void delete(UserAccountDto.UserAccountDeleteReq dto) {
        userAccountMapper.delete(dto);
    }

}
