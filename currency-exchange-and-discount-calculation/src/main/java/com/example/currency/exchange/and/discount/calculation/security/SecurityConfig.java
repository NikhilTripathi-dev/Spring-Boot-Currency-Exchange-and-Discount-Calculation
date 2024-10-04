package com.example.currency.exchange.and.discount.calculation.security;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@org.springframework.context.annotation.Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .requestMatchers("/api/calculate").authenticated()
            .and()
            .httpBasic(); // Basic Authentication

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.withDefaultPasswordEncoder()
            .username("employee")
            .password("password")
            .roles("EMPLOYEE")
            .build();

        UserDetails user2 = User.withDefaultPasswordEncoder()
            .username("affiliate")
            .password("password")
            .roles("AFFILIATE")
            .build();

        UserDetails user3 = User.withDefaultPasswordEncoder()
            .username("customer")
            .password("password")
            .roles("CUSTOMER")
            .build();

        return new InMemoryUserDetailsManager(user1, user2, user3);
    }
}
