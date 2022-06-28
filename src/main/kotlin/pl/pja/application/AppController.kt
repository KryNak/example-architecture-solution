package pl.pja.application

import org.axonframework.messaging.responsetypes.ResponseTypes
import org.axonframework.queryhandling.QueryGateway
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import pl.pja.domain.model.Suitcase
import pl.pja.domain.queries.FindSuitcasesByCountryAndCityNameQuery
import pl.pja.domain.queries.FindSuitcasesByNameQuery

@RestController
@RequestMapping(path = ["/api"])
class AppController(
    val queryGateway: QueryGateway
) {

    @GetMapping("/countries/{countyName}/cities/{cityName}/suitcases")
    @ResponseStatus(HttpStatus.OK)
    fun findAllSuitcasesInCity(@PathVariable countyName: String, @PathVariable cityName: String): List<Suitcase> {
        return queryGateway
            .query(FindSuitcasesByCountryAndCityNameQuery(countyName, cityName), ResponseTypes.multipleInstancesOf(Suitcase::class.java))
            .get()
    }

    @GetMapping("/suitcases/{suitcaseName}")
    @ResponseStatus(HttpStatus.OK)
    fun findSuitcaseByName(@PathVariable suitcaseName: String): List<Suitcase> {
        return queryGateway
            .query(FindSuitcasesByNameQuery(suitcaseName), ResponseTypes.multipleInstancesOf(Suitcase::class.java))
            .get()
    }


    fun addItemToSuitcase() {

    }

    fun removeItemFromSuitcase() {

    }

    fun toggleItemAsPacked() {

    }

    @DeleteMapping("/suitcases/{id}")
    fun deleteSuitcase() {

    }

}
