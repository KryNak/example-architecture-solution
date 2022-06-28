package pl.pja.configuration

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import pl.pja.infrastructure.entities.CityEntity
import pl.pja.infrastructure.entities.CountryEntity
import pl.pja.infrastructure.entities.SuitcaseEntity
import pl.pja.infrastructure.repositories.SuitcaseRepository

@Component
class AppRunner(
    val suitcaseRepository: SuitcaseRepository
): CommandLineRunner {

    override fun run(vararg args: String?) {
        val country = CountryEntity("Poland")

        val city1 = CityEntity("Warsaw")
        val city2 = CityEntity("Wroclaw")
        val city3 = CityEntity("Krakow")

        val suitcase1 = SuitcaseEntity("suitcase1")
        val suitcase2 = SuitcaseEntity("suitcase2")
        val suitcase3 = SuitcaseEntity("suitcase3")
        val suitcase4 = SuitcaseEntity("suitcase4")
        val suitcase5 = SuitcaseEntity("suitcase5")

        city1.country = country
        city2.country = country
        city3.country = country

        suitcase1.city = city1
        suitcase2.city = city1
        suitcase3.city = city2
        suitcase4.city = city2
        suitcase5.city = city3

        suitcaseRepository.saveAll(listOf(suitcase1, suitcase2, suitcase3, suitcase4, suitcase5))
    }
}
