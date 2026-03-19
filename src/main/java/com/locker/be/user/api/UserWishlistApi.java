package com.locker.be.user.api;

import com.locker.be.user.dto.UserAccountDto;
import com.locker.be.user.dto.UserQueryDto;
import com.locker.be.user.dto.UserWishlistDto;
import com.locker.be.user.service.UserService;
import com.locker.be.user.service.UserWishlistService;
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
@RequestMapping("user/wishlist")
@Tag(name = "찜 API", description = "찜을 위한 API 입니다.")
public class UserWishlistApi {

    private final UserWishlistService userWishlistService;
    private final UserService userService;

    @PutMapping("/save")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "찜을 입력/삭제 합니다.")
    public void save(@RequestBody final UserWishlistDto.UserWishlistSaveReq dto) {
        userWishlistService.save(dto);
    }

    @GetMapping("/select")
    @Operation(summary = "검색조건에 따른 찜리스트에 대한 데이터를 반환합니다.")
    public Collection<UserQueryDto.UserWishlistRes> findWish(@ModelAttribute final UserQueryDto.UserInfoReq dto) {
        return userService.findWish(dto);
    }
}
