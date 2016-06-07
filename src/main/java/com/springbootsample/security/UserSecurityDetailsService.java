package com.springbootsample.security;

import com.springbootsample.models.User;
import com.springbootsample.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mamba on 6/6/16.
 *
 * Customize UserDetailsService
 */
@Component
public class UserSecurityDetailsService implements UserDetailsService {
  @Autowired
  UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByNicknameOrMobileIgnoreCase(username, username);
    if (user == null) throw new UsernameNotFoundException("User [" + username + "] Not Found.");

    Set<GrantedAuthority> authorities = new HashSet<>();
    user.getRoles().forEach(r -> authorities.add(new SimpleGrantedAuthority(r.getName())));

    return new org.springframework.security.core.userdetails.User(
        username, user.getPassword(),
        user.getEnabled(),//是否可用
        true,//是否过期
        true,//证书不过期为true
        true,//账户未锁定为true
        authorities
    );
  }
}
