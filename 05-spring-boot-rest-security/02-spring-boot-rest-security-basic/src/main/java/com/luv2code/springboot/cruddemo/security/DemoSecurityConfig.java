package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {

        UserDetails john = org.springframework.security.core.userdetails.User.withUsername("john")
                .password("{noop}test123").roles("EMPLOYEE").build();

        UserDetails mary = org.springframework.security.core.userdetails.User.withUsername("mary")
                .password("{noop}test123").roles("EMPLOYEE", "MANAGER").build();

        UserDetails susan = org.springframework.security.core.userdetails.User.withUsername("susan")
                .password("{noop}test123").roles("EMPLOYEE", "ADMIN").build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }
}
