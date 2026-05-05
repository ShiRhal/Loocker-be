package com.locker.be.web.user.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.security.Principal;

@Getter
@AllArgsConstructor
public class JwtUserPrincipal implements Principal {

    private Long userId;

    @Override
    public String getName() {
        return String.valueOf(userId);
    }
}