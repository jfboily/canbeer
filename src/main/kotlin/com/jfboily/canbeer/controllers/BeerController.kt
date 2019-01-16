package com.jfboily.canbeer.controllers

import com.jfboily.canbeer.domain.repositories.BeerRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
class BeerController(val beerRepository: BeerRepository) {

    @GetMapping("/beers")
    fun getAllBeers() = beerRepository.findAll()

    @GetMapping("/beers/{id}")
    fun getBeer(@PathVariable id: Long) =
            beerRepository.findById(id).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found") }
}