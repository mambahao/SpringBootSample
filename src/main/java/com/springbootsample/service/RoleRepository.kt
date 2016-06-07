package com.springbootsample.service

import com.springbootsample.models.Role
import org.springframework.data.repository.Repository

/**
 * Created by Mamba on 6/6/16.

 * Role Repository
 */
interface RoleRepository : Repository<Role, Long> {}
