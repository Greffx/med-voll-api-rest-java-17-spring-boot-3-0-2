package med.voll.api.config.security;

import med.voll.api.security.SecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity //to enable configuration to security
public class SecurityConfig {

    @Autowired
    private SecurityFilter filter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf().disable() //csrf to disable attacks from CROSS-SITE REQUEST FORGERY
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //turning stateless, not stateful, cuz this is restfull
                .and().authorizeHttpRequests() //configuration for authorization
                .requestMatchers(HttpMethod.POST, "/login").permitAll() //only permitting with login
                .anyRequest().authenticated() //any request only with authentication
                .and().addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class) //organizing filter by order, my first, spring after
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception { //manager for controller
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
