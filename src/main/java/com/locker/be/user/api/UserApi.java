package com.locker.be.user.api;

import com.locker.be.user.dto.UserDto;
import com.locker.be.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("user")
@Tag(name = "유저 API", description = "유저를 위한 API 입니다.")
public class UserApi {

    private final UserService userService;

    @PutMapping("/nickname/update")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "닉네임을 수정 합니다.")
    public void update(@RequestBody final UserDto.UserUpdateReq dto) {
        userService.update(dto);
    }

    @PutMapping("/ban")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "사용자를 벤합니다.")
    public void banned(@RequestBody final UserDto.UserBannedReq dto) {
        userService.banned(dto);
    }

    @PutMapping("/delete")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "사용자의 상태를 DELETED로 수정 합니다.")
    public void delete(@RequestBody final UserDto.UserDeleteReq dto) {
        userService.delete(dto);
    }
}
