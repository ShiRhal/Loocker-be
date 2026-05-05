package com.locker.be.web.user.mapper;

import com.locker.be.web.user.dto.AuthDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthMapper {

    AuthDto.UserInfo loginOrRegisterGoogle(AuthDto.GoogleUserUpsertParam param);

    AuthDto.MeRes selectMe(Long userId);
}