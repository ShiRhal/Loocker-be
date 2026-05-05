package com.locker.be.web.user.api;

import com.locker.be.web.user.dto.UserAddressDto;
import com.locker.be.web.user.dto.UserQueryDto;
import com.locker.be.web.user.service.UserAddressService;
import com.locker.be.web.user.service.UserService;
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
@RequestMapping("web/user/address")
@Tag(name = "주소 API", description = "주소를 위한 API 입니다.")
public class UserAddressApi {

    private final UserAddressService userAddressService;
    private final UserService userService;

    @PutMapping("/create")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "주소를 입력 합니다.")
    public void create(@RequestBody final UserAddressDto.UserAddressCreateReq dto) {
        userAddressService.create(dto);
    }

    @PutMapping("/update")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "주소를 수정 합니다.")
    public void update(@RequestBody final UserAddressDto.UserAddressUpdateReq dto) {
        userAddressService.update(dto);
    }

    @PutMapping("/delete")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "주소를 삭제 합니다.")
    public void delete(@RequestBody final UserAddressDto.UserAddressDeleteReq dto) {
        userAddressService.delete(dto);
    }

    @GetMapping("/select")
    @Operation(summary = "검색조건에 따른 주소리스트에 대한 데이터를 반환합니다.")
    public Collection<UserQueryDto.UserAddressRes> findAddress(@ModelAttribute final UserQueryDto.UserInfoReq dto) {
        return userService.findAddress(dto);
    }
}
