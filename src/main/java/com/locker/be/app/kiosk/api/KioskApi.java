package com.locker.be.app.kiosk.api;

import com.locker.be.app.kiosk.dto.KioskQueryDto;
import com.locker.be.app.kiosk.service.KioskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("kiosk")
@Tag(name = "키오스크 API", description = "키오스크를 위한 api 입니다.")
public class KioskApi {

    @Value("${kiosk.allowed-code}")
    private String kioskAllowedCode;

    private final KioskService kioskService;

    @GetMapping("/login")
    @Operation(summary = "지점 로그인.")
    public Collection<KioskQueryDto.KioskInfoRes> kioskLogin(KioskQueryDto.KioskLoginReq dto) {
        return kioskService.kioskLogin(dto);
    }

    @GetMapping("/verify")
    public ResponseEntity<Void> verify(@RequestParam String CODE) {
        if (!kioskAllowedCode.equals(CODE)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok().build();
    }
}
