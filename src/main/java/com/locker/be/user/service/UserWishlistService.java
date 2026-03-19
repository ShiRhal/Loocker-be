package com.locker.be.user.service;

import com.locker.be.user.dto.UserWishlistDto;
import com.locker.be.user.mapper.UserWishlistMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserWishlistService {

    private final UserWishlistMapper userWishlistMapper;

    public void save(UserWishlistDto.UserWishlistSaveReq dto) {
        userWishlistMapper.save(dto);
    }
}
