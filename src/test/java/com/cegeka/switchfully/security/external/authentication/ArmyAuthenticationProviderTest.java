package com.cegeka.switchfully.security.external.authentication;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.core.AuthenticationException;

import static org.mockito.Mockito.when;

public class ArmyAuthenticationProviderTest {

    @Mock
    private FakeAuthenticationService service;

    @Mock
    private ArmyAuthentication zwanetta;

    @Mock
    private ArmyAuthentication unknownUser;

    @InjectMocks
    private ArmyAuthenticationProvider provider;

    @Before
    public void setUp() {
        provider = new ArmyAuthenticationProvider();
        when(unknownUser.getPrincipal()).thenReturn("FAKER");
        when(unknownUser.getCredentials()).thenReturn("FAKE");
    }

    @Test
    public void getUser_whenGivenUnknownUser_shouldThrowException() {
//        Assertions.assertThatThrownBy(provider.authenticate(unknownUser)).isInstanceOf(AuthenticationException.class);
    }
}