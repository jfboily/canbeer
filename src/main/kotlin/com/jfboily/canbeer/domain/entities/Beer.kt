package com.jfboily.canbeer.domain.entities

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Lob


@Entity
data class Beer(
        @Id
        val id: Long = -1,
        val name: String,
        val brewery_id: Long,
        val alcohol_pc: Double,
        @Lob
        val description: String,
        val style: String,
        val category: String

)