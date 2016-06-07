package com.springbootsample.security;

import com.springbootsample.models.User;
import com.springbootsample.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by Mamba on 6/6/16.
 *
 * Customize PermissionEvaluator
 */
@Component
public class UserSecurityPermissionEvaluator implements PermissionEvaluator {
  @Autowired
  private UserRepository userRepository;

  @Override
  public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
    String username = authentication.getName();
    User user = userRepository.findByNicknameOrMobileIgnoreCase(username, username);

    return user != null;
  }

  @Override
  public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
    // not supported
    return false;
  }
}
