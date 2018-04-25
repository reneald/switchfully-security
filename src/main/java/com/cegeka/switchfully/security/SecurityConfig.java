package com.cegeka.switchfully.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationEntryPoint authEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                .antMatchers("/private/*").hasRole("PRIVATE")
//                .antMatchers("/*").hasRole("CIVILIAN")
//                .antMatchers("/promote/*").hasRole("HUMAN_RELATIONSHIPS")
//                .antMatchers("/discharge/*").hasRole("HUMAN_RELATIONSHIPS")
//                .antMatchers("/nuke/*").hasRole("GENERAL")
                .and().httpBasic()
                .authenticationEntryPoint(authEntryPoint);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("ZWANETTA").password("WORST").roles("CIVILIAN")
                .and()
                .withUser("JMILLER").password("THANKS").roles("PRIVATE")
                .and()
                .withUser("UNCLE").password("SAM").roles("HUMAN_RELATIONSHIPS")
                .and()
                .withUser("GENNY").password("RALLY").roles("GENERAL");
    }

}
