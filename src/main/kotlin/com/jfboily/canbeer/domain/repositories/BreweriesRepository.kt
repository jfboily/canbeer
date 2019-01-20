package com.jfboily.canbeer.domain.repositories

import com.jfboily.canbeer.domain.entities.Brewery
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BreweriesRepository : CrudRepository<Brewery, Long>