package com.iba.festival.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN, SPEAKER;

    @Override
    public String getAuthority() {
        return name();
    }
}
