package com.locker.be.user.api;

import com.locker.be.user.dto.UserDto;
import com.locker.be.user.dto.UserQueryDto;
import com.locker.be.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("user")
@Tag(name = "유저 API", description = "유저를 위한 API 입니다.")
public class UserApi {

    private final UserService userService;

    @GetMapping("/nickname/select")
    @Operation(summary = "검색조건에 따른 닉네임에 대한 데이터를 반환합니다.")
    public UserQueryDto.UserRes findUser(@ModelAttribute final UserQueryDto.UserInfoReq dto) {
        return userService.findUser(dto);
    }

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

    @GetMapping("/info/select")
    @Operation(summary = "검색조건에 따른 마이페이지에 대한 데이터를 반환합니다.")
    public UserQueryDto.UserInfoRes findInfo(@ModelAttribute final UserQueryDto.UserInfoReq dto) {
        return userService.findInfo(dto);
    }
}
