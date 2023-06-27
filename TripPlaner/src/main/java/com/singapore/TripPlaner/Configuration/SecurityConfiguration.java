package com.singapore.TripPlaner.Configuration;

import com.singapore.TripPlaner.Model.User.User;
import com.singapore.TripPlaner.Repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfiguration(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/login", "/user/registration", "/city", "/place", "/trip", "/images").permitAll()
                .antMatchers(HttpMethod.POST).hasAnyRole("ADMIN")
                .antMatchers("/users").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .defaultSuccessUrl("/", true)
                .failureUrl("/login.html?error=true")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
                .csrf().disable();
    }

    protected void configurationGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder.bCryptPasswordEncoder());
    }

    public UserDetails loadUserByEmail(String email)
            throws UsernameNotFoundException {

        Optional<User> user = userRepository.findUserByEmail(email);

        if (user.isEmpty())
            throw new UsernameNotFoundException("Bad credentials");

        return new User(
                user.get().getLogin(),
                user.get().getUsername(),
                user.get().getEmail(),
                user.get().getPassword(),
                user.get().getUserRole(),
                user.get().getLocked(),
                user.get().getEnabled()
        );
    }
}
