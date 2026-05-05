package com.locker.be.web.admin.api;

import com.locker.be.web.admin.dto.AdminQueryDto;
import com.locker.be.web.admin.service.AdminService;
import com.locker.be.web.code.dto.CodeQueryDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("web/amin")
@Tag(name = "관리자 API", description = "관리자 로그인을 위한 api 입니다.")
public class AdminApi {

    private final AdminService adminService;

    @GetMapping("/login")
    @Operation(summary = "관리자 로그인.")
    public Collection<AdminQueryDto.AdminRes> login(AdminQueryDto.AdminReq dto) {
        return adminService.login(dto);
    }

}
