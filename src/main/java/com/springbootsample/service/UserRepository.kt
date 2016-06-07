package com.springbootsample.service

import com.springbootsample.models.User
import org.springframework.data.repository.Repository

/**
 * Created by Mamba on 6/6/16.

 * User Repository
 */
interface UserRepository : Repository<User, Long> {
  fun findByNicknameOrMobileIgnoreCase(nickname: String, mobile: String): User?
}
