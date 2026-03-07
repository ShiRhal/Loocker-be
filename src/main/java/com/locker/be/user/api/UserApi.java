package com.locker.be.user.api;

import com.locker.be.user.dto.UserDto;
import com.locker.be.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("user")
@Tag(name = "유저 API", description = "유저를 위한 API 입니다.")
public class UserApi {

    private UserService userService;

    @PutMapping("/nickname/update")
    @Operation(summary = "닉네임을 수정 합니다.")
    public void update(UserDto.UserUpdateReq dto) {
        userService.update(dto);
    }

    @PutMapping("/ban")
    @Operation(summary = "사용자를 벤합니다.")
    public void banned(UserDto.UserBannedReq dto) {
        userService.banned(dto);
    }

    @PutMapping("/delete")
    @Operation(summary = "사용자의 상태를 DELETED로 수정 합니다.")
    public void delete(UserDto.UserDeleteReq dto) {
        userService.delete(dto);
    }
}
