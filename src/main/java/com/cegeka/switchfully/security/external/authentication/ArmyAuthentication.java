package com.cegeka.switchfully.security.external.authentication;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ArmyAuthentication implements Authentication {

    private List<SimpleGrantedAuthority> roles = new ArrayList();
    private String username;
    private String password;
    private boolean isAuthenticated = true;

    public ArmyAuthentication(List<String> roles, String username, String password) {
        this.roles = roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        this.username = username;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public Object getCredentials() {
        return password;
    }

    @Override
    public Object getDetails() {
        return "";
    }

    @Override
    public Object getPrincipal() {
        return username;
    }

    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        this.isAuthenticated = b;
    }

    @Override
    public String getName() {
        return username;
    }
}
