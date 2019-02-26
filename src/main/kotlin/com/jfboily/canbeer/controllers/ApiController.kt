package com.jfboily.canbeer.controllers

import com.jfboily.canbeer.domain.repositories.BeersRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/v1")
class BeerController(val beersRepository: BeersRepository) {

    @GetMapping("/beers")
    fun getAllBeers() = beersRepository.findAll()

    @GetMapping("/beers/{id}")
    fun getBeer(@PathVariable id: Long) =
            beersRepository.findById(id).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found") }

    @GetMapping("/strong-beers")
    fun getStrongBeers() = beersRepository.findAll().filter { it.abv > 6 }

    @GetMapping("/light-beers")
    fun getLightBeers() = beersRepository.findAll().filter { it.abv < 5 }
}