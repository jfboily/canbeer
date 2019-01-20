package com.jfboily.canbeer

import com.jfboily.canbeer.domain.entities.Beer
import com.jfboily.canbeer.domain.entities.Brewery
import com.jfboily.canbeer.domain.repositories.BeersRepository
import com.jfboily.canbeer.domain.repositories.BreweriesRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class CanbeerApplication {
    @Bean
    fun init(beersRepository: BeersRepository, breweriesRepository: BreweriesRepository) = ApplicationRunner {

        // breweries
        val laSouche = Brewery(1,"La souche", "801 ch. de la Canardière, Québec, QC, G1J 2B8", "5817421144")
        val inox = Brewery(2, "Inox", "655 Grande Allée Est, Québec, QC,  G1R 2K4", "4186922877")
        val griendel = Brewery(3, "Griendel", "195 Saint-Vallier Ouest, Québec, QC, G1K 1J9", "5817422884")
        breweriesRepository.save(laSouche)
        breweriesRepository.save(inox)
        breweriesRepository.save(griendel)


        // beers : La Souche
        beersRepository.save(Beer(0,"La canardière", laSouche, 7.0, 62, "Double IPA"))
        beersRepository.save(Beer(0, "Franc-Bois", laSouche, 4.5, 15, "Bière de ble aux framboises"))
        beersRepository.save(Beer(0,"Gros Pin", laSouche, 5.0, 27, "Irish Red"))
        beersRepository.save(Beer(0,"Jackie Dunn", laSouche, 4.0, 40, "Session IPA"))
        beersRepository.save(Beer(0, "Limoiloise", laSouche, 5.0, 20, "Pale Ale Anglaise"))
        beersRepository.save(Beer(0, "Limoilou Beach", laSouche, 6.5, 15, "Bière de blé sûre aux cassis"))
        beersRepository.save(Beer(0, "Mont Wright", laSouche, 7.5, 90, "Double IPA"))
        beersRepository.save(Beer(0, "Parkeville", laSouche, 5.5, 40, "PAle Ale Américaine"))
        beersRepository.save(Beer(0, "La Saint-Charles", laSouche, 3.5, 30, "Brown Ale"))

        // beers : Inox

        beersRepository.save(Beer(0,"Labrosse", inox, 5.0, 30, "Blonde & Lager"))
        beersRepository.save(Beer(0,"Trouble-fête", inox, 4.5, 15, "Blanche croisee"))
        beersRepository.save(Beer(0,"Double IPA", inox, 8.0, 75, "Double IPA"))
        beersRepository.save(Beer(0,"Trois de pique", inox, 4.5, 25, "Rousse ESB Anglaise"))
        beersRepository.save(Beer(0,"Sortilège", inox, 5.0, 20, "Stout"))
        beersRepository.save(Beer(0,"Scotch Ale", inox, 7.0, 20, "Brune Scotch Ale"))

        // beers : Griendel
        beersRepository.save(Beer(0,"Kölsch du Clocher", griendel, 5.3, 25, "Kölsch"))
        beersRepository.save(Beer(0,"St-So", griendel, 4.5, 35, "Bitter"))
        beersRepository.save(Beer(0,"Yosémite #1", griendel, 5.6, 45, "IPA (India Pale Ale) Belma & El dorado"))
        beersRepository.save(Beer(0,"Zénith", griendel, 5.0, 25, "Pale Ale Brett"))
        beersRepository.save(Beer(0,"Stinson Beach", griendel, 6.5, 60, "IPA Americaine"))
        beersRepository.save(Beer(0,"Jolly Jumper", griendel, 3.5, 35, "Session IPA"))

    }
}

fun main(args: Array<String>) {
    runApplication<CanbeerApplication>(*args) {
        setBannerMode(Banner.Mode.CONSOLE)
    }
}



