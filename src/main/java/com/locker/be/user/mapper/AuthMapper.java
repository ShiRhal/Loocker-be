package com.locker.be.user.mapper;

import com.locker.be.user.dto.AuthDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthMapper {

    AuthDto.UserInfo loginOrRegisterGoogle(AuthDto.GoogleUserUpsertParam param);

    AuthDto.MeRes selectMe(Long userId);
}