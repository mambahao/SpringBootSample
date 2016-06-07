package com.springbootsample.models

import javax.persistence.*

/**
 * Created by Mamba on 6/6/16.
 *
 * Role Privilege
 */
@Entity
@Table(name = "privileges")
data class Privilege(
  @Id
  @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
  val id: Long = 0,
  val name: String = "",

  @ManyToMany(mappedBy = "privileges")
  val users: Collection<Role> = listOf()
)
