package com.cegeka.switchfully.security.external.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class ArmyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private FakeAuthenticationService service;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        ExternalAuthenticaton user = service.getUser(authentication.getPrincipal().toString(), authentication.getCredentials().toString());
        if (user == null) {
            throw new BadCredentialsException("Incorrect username of password!");
        } else {
            return new ArmyAuthentication(user.getRoles(), user.getUsername(), user.getPassword());
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
