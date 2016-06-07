package com.springbootsample.models

import javax.persistence.*

/**
 * Created by Mamba on 6/6/16.
 *
 * User
 */
@Entity
@Table(name = "users")
data class User(
  @Id
  @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
  val id: Long = 0,
  val nickname: String = "",
  val mobile: String = "",
  val password: String = "",
  val email: String = "",
  val firstName: String = "",
  val lastName: String = "",
  val enabled: Boolean = true,
  val tokenExpired: Boolean = false,

  @ManyToMany(fetch= javax.persistence.FetchType.EAGER)
  @JoinTable(
    name = "users_roles",
    joinColumns = arrayOf(javax.persistence.JoinColumn(name = "user_id", referencedColumnName = "id")),
    inverseJoinColumns = arrayOf(javax.persistence.JoinColumn(name = "role_id", referencedColumnName = "id"))
  )
  val roles: Collection<Role> = listOf()
)
