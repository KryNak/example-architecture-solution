package pl.pja.infrastructure.entities

import java.util.UUID
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "Country")
class CountryEntity() {

    @Id
    @Column(name = "IdCountry")
    var id: String = UUID.randomUUID().toString()

    @Column(name = "Name", nullable = false)
    var name: String = ""

    @OneToMany(mappedBy = "country", cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    var cities: MutableSet<CityEntity> = mutableSetOf()

    constructor(name: String): this() {
        this.name = name
    }

}
