// package com.example.VotingSystem.config;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.context.config.DelegatingApplicationListener;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Lazy;
// import org.springframework.security.config.Customizer;
// import
// org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import
// org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

// @Configuration
// @EnableWebSecurity
// @EnableMethodSecurity
// @Lazy
// public class SecurityConfig {

// private final UserDetailsService userDetailsService;
// private final PasswordEncoder passwordEncoder;

// @Autowired
// public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder
// passwordEncoder) {
// this.userDetailsService = userDetailsService;
// this.passwordEncoder = passwordEncoder;
// }

// protected void configure(HttpSecurity http) throws Exception {
// http.authorizeHttpRequests(t -> t
// .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
// .requestMatchers("/admin/**").hasRole("ADMIN")
// .requestMatchers("/user/**").hasRole("USER")
// .anyRequest().authenticated());

// http.formLogin(Customizer.withDefaults());

// http.logout(l -> l
// .logoutSuccessUrl("/")
// .permitAll());

// http.exceptionHandling(e -> e
// .accessDeniedPage("/403"));

// }

// @Autowired
// public void configureGlobal(AuthenticationManagerBuilder auth) throws
// Exception {
// auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
// }

// @Bean
// public PasswordEncoder passwordEncoder() {
// return new BCryptPasswordEncoder();
// }

// @Bean
// public DelegatingApplicationListener customDelegatingApplicationListener() {
// return new DelegatingApplicationListener();
// }

// }
