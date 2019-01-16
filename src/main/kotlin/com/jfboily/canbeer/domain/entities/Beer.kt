package com.jfboily.canbeer.domain.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Beer(
        @Id
        @GeneratedValue
        val id: Long = -1,
        val name: String
)