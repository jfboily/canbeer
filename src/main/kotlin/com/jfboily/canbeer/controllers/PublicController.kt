package com.jfboily.canbeer.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PublicController {

    @GetMapping("/")
    fun welcome() = "Welcome."

    @GetMapping("/help")
    fun help() = "To use the beer API you need an access token from http://localhost:8180/auth.\nThe API is at /api/v1/beers."
}