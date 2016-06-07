package com.springbootsample.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by Mamba on 6/6/16.
 * <p>
 * Customize WebSecurityConfigurerAdapter
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserSecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  UserSecurityDetailsService userSecurityDetailsService;

  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setPasswordEncoder(passwordEncoder());
    authenticationProvider.setUserDetailsService(userSecurityDetailsService);

    return authenticationProvider;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authenticationProvider());
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/js/**", "/css/**", "/img/**", "/**/favicon.ico");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // 无需验证
    http.authorizeRequests().antMatchers("/", "/index.html", "/js/**", "/css/**", "/img/**", "/**/favicon.ico").permitAll()
        // 默认剩余的 URL 全部验证
        .and().authorizeRequests().anyRequest().authenticated()
        // 用户登录
        .and().formLogin().loginPage("/login.html").permitAll().defaultSuccessUrl("/index.html", true)
        .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout.html")).permitAll()
        // Remember Me
        .and().rememberMe()
        // 屏蔽 csrf
        .and().csrf().disable();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
