package com.jfboily.canbeer

import com.beust.klaxon.JsonReader
import com.beust.klaxon.Klaxon
import com.jfboily.canbeer.domain.entities.Beer
import com.jfboily.canbeer.domain.repositories.BeerRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.io.FileReader

@SpringBootApplication
class CanbeerApplication {
    @Bean
    fun init(beerRepository: BeerRepository) = ApplicationRunner {
        val klaxon = Klaxon()
        JsonReader(FileReader("./data/beers.json")).use { reader ->
            reader.beginArray {
                while (reader.hasNext()) {
                    val beer = klaxon.parse<Beer>(reader)
                    if(beer != null) {
                        beerRepository.save(beer)
                    }
                }
            }
        }
    }
}

fun main(args: Array<String>) {
    runApplication<CanbeerApplication>(*args) {
        setBannerMode(Banner.Mode.CONSOLE)
    }
}



