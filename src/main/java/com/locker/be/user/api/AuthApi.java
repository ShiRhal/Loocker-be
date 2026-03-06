package com.locker.be.user.api;

import com.locker.be.user.dto.AuthDto;
import com.locker.be.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthApi {

    private final AuthService authService;

    @PostMapping("/google")
    public ResponseEntity<AuthDto.GoogleLoginRes> googleLogin(@RequestBody AuthDto.GoogleLoginReq req) {
        return ResponseEntity.ok(authService.googleLogin(req));
    }

    @GetMapping("/me")
    public ResponseEntity<AuthDto.MeRes> me() {
        return ResponseEntity.status(401).build();
    }
}