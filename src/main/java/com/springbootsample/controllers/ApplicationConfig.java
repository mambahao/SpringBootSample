package com.springbootsample.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Mamba on 6/6/16.
 *
 * MVC Controller Config
 */
@Configuration
@EnableRedisHttpSession
public class ApplicationConfig extends WebMvcConfigurerAdapter {
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/login.html").setViewName("login");
  }
}
