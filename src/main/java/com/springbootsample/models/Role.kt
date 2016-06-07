package com.springbootsample.models

import javax.persistence.*

/**
 * Created by Mamba on 6/6/16.
 *
 * Role
 */
@Entity
@Table(name = "roles")
data class Role(
    @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  val id: Long = 0,
    val name: String = "",


    @ManyToMany(mappedBy = "roles")
  val users: Collection<User> = listOf(),

    @ManyToMany
  @JoinTable(
    name = "roles_privileges",
    joinColumns = arrayOf(JoinColumn(name = "role_id", referencedColumnName = "id")),
    inverseJoinColumns = arrayOf(JoinColumn(name = "privilege_id", referencedColumnName = "id"))
  )
  val privileges: Collection<Privilege> = listOf()
)
