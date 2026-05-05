package com.locker.be.web.user.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.security.Principal;

@Getter
@AllArgsConstructor
public class JwtUserPrincipal implements Principal {
    private Long userId;
    private String kioskLoginId;
    private String tokenType;

    public static JwtUserPrincipal user(Long userId) {
        return new JwtUserPrincipal(userId, null, "USER");
    }

    public static JwtUserPrincipal kiosk(String kioskLoginId) {
        return new JwtUserPrincipal(null, kioskLoginId, "KIOSK");
    }

    @Override
    public String getName() {
        if ("KIOSK".equals(tokenType)) {
            return kioskLoginId;
        }

        return String.valueOf(userId);
    }
}