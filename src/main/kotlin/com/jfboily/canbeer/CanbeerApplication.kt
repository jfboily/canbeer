package com.jfboily.canbeer

import com.beust.klaxon.JsonReader
import com.beust.klaxon.Klaxon
import org.springframework.boot.Banner
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.io.StringReader

@SpringBootApplication
class CanbeerApplication : CommandLineRunner{
    override fun run(vararg args: String?) {
        println("POUET!")
    }
}

fun main(args: Array<String>) {
    runApplication<CanbeerApplication>(*args) {
        setBannerMode(Banner.Mode.CONSOLE)
    }
}

