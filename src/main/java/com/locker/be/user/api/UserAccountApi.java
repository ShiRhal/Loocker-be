package com.locker.be.user.api;

import com.locker.be.user.dto.UserAccountDto;
import com.locker.be.user.dto.UserDto;
import com.locker.be.user.dto.UserQueryDto;
import com.locker.be.user.service.UserAccountService;
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
@RequestMapping("user/account")
@Tag(name = "계좌 API", description = "계좌를 위한 API 입니다.")
public class UserAccountApi {

    private final UserAccountService userAccountService;
    private final UserService userService;

    @PutMapping("/create")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "계좌를 입력 합니다.")
    public void create(@RequestBody final UserAccountDto.UserAccountCreateReq dto) {
        userAccountService.create(dto);
    }

    @PutMapping("/update")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "계좌를 수정 합니다.")
    public void update(@RequestBody final UserAccountDto.UserAccountUpdateReq dto) {
        userAccountService.update(dto);
    }

    @PutMapping("/delete")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "계좌를 삭제 합니다.")
    public void delete(@RequestBody final UserAccountDto.UserAccountDeleteReq dto) {
        userAccountService.delete(dto);
    }

    @GetMapping("/select")
    @Operation(summary = "검색조건에 따른 계좌리스트에 대한 데이터를 반환합니다.")
    public Collection<UserQueryDto.UserAccountRes> findAccount(@ModelAttribute final UserQueryDto.UserInfoReq dto) {
        return userService.findAccount(dto);
    }
}
