package web.model;

import org.springframework.security.core.GrantedAuthority;

public enum  Role implements GrantedAuthority {
    USER,
    READ,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
