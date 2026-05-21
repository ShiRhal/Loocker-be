package com.locker.be.app.kiosk.api;

import com.locker.be.app.kiosk.dto.KioskAuthQueryDto;
import com.locker.be.app.kiosk.service.KioskAuthService;
import com.locker.be.app.kiosk.dto.KioskAuthDto;
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
@RequestMapping("kiosk/auth")
@Tag(name = "키오스크 API", description = "키오스크를 위한 api 입니다.")
public class KioskAuthApi {

    private final KioskAuthService kioskAuthService;

    @GetMapping("/select")
    @Operation(summary = "qr 로그인 정보 조회")
    public Collection<KioskAuthQueryDto.KioskAuthRes> findAuth(KioskAuthQueryDto.KioskAuthReq dto) {
        return kioskAuthService.findAuth(dto);
    }

    @PutMapping("/update")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "데이터를 입력합니다.")
    public void update(@RequestBody final KioskAuthDto.KioskAuthUpdateReq dto, @RequestHeader("Authorization") String authorization) {
        String token = authorization.replace("Bearer ", "");
        kioskAuthService.update(dto, token);
    }

    @PutMapping("/create")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "데이터를 입력합니다.")
    public String create(@RequestBody final KioskAuthDto.KioskAuthCreateReq dto) {
        return kioskAuthService.create(dto);
    }
}
