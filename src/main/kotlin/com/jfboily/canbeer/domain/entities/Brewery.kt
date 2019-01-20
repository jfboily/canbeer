package com.jfboily.canbeer.domain.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Brewery(
        @Id
        @GeneratedValue
        val id: Long = -1,
        val name: String,
        val address: String,
        val phone: String
)