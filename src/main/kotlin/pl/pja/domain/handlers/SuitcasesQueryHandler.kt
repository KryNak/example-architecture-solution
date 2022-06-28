package pl.pja.domain.handlers

import org.axonframework.queryhandling.QueryHandler
import org.springframework.stereotype.Component
import pl.pja.domain.model.Suitcase
import pl.pja.domain.queries.FindSuitcasesByCountryAndCityNameQuery
import pl.pja.domain.queries.FindSuitcasesByNameQuery
import pl.pja.infrastructure.entities.SuitcaseEntity
import pl.pja.infrastructure.repositories.SuitcaseRepository

@Component
class SuitcasesQueryHandler(
    val suitcaseRepository: SuitcaseRepository
) {

    @QueryHandler
    fun handle(query: FindSuitcasesByCountryAndCityNameQuery): List<Suitcase> {
        return suitcaseRepository.findAll()
            .filter { it.city.name == query.cityName }
            .map(this::toSuitcaseModel)
    }

    @QueryHandler
    fun handle(query: FindSuitcasesByNameQuery): List<Suitcase> {
        return suitcaseRepository.findAll()
            .filter { it.name.contains(query.name) }
            .map(this::toSuitcaseModel)

    }

    fun toSuitcaseModel(it: SuitcaseEntity): Suitcase {
        return Suitcase(
            suitcaseName = it.name,
            cityName = it.city.name,
            countryName = it.city.country.name
        )
    }

}
