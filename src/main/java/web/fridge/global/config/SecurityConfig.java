package web.fridge.global.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import web.fridge.domain.jwt.JwtProvider;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtProvider jwtProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable()
                .headers().frameOptions().disable()
                .and().authorizeHttpRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/members").permitAll()
                .antMatchers("/**").permitAll()
                .anyRequest().permitAll();

        return httpSecurity.build();
        // return httpSecurity.addFilterBefore(new JwtAuthenticationFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class).build();
    }
}
