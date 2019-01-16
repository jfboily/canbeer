package com.jfboily.canbeer.domain.repositories

import com.jfboily.canbeer.domain.entities.Beer
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface BeerRepository : CrudRepository<Beer, Long>