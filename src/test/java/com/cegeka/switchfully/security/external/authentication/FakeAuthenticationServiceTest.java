package com.cegeka.switchfully.security.external.authentication;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FakeAuthenticationServiceTest {
    private FakeAuthenticationService service;

    @Before
    public void setUp() {
        service = new FakeAuthenticationService();
    }

    @Test
    public void getUser_whenGivenKnownUserWithCorrectPassword_shouldReturnExternalAuthentication() {
        ExternalAuthenticaton user = service.getUser("ZWANETTA", "WORST");

        assertThat(user).isNotNull();
    }

    @Test
    public void getUser_whenGivenUnknownUser_shouldReturnNull() {
        ExternalAuthenticaton user = service.getUser("ROGER", "WATERS");

        assertThat(user).isNull();
    }

    @Test
    public void getUser_whenGivenKnownUserWithWrongPassword_shouldReturnNull() {
        ExternalAuthenticaton user = service.getUser("ZWANETTA", "WATERS");

        assertThat(user).isNull();
    }

}