package dev.piper_jones.community_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration //tells it to look here for bean definitions
@EnableWebSecurity //allows for custom rules
public class SecurityConfiguration {

    @Bean //defining multiple security chains below
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((requests) -> requests
            .requestMatchers("/rest/public").permitAll()
            .requestMatchers("rest/admin").hasRole("ADMIN")
            .requestMatchers("rest/user").hasRole("USER")
        ).httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin= User.withDefaultPasswordEncoder()
        .username("admin")
        .password("admin-pass")
        .roles("ADMIN", "USER")
        .build();

        UserDetails user= User.withDefaultPasswordEncoder()
        .username("user")
        .password("user-pass")
        .roles("USER")
        .build();

        return new InMemoryUserDetailsManager(admin, user);
    }



}