package com.jfboily.canbeer.domain.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne


@Entity
data class Beer(
        @Id
        @GeneratedValue
        val id: Long = -1,
        val name: String,
        @ManyToOne
        val brewery: Brewery,
        val abv: Double,
        val ibu: Int,
        val style: String

)