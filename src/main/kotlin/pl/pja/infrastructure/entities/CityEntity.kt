package pl.pja.infrastructure.entities

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "City")
class CityEntity() {

    @Id
    @Column(name = "IdCity")
    var id: String = UUID.randomUUID().toString()

    @Column(name = "Name", nullable = false)
    var name: String = ""

    @ManyToOne(cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinColumn(name = "IdCountry", nullable = false)
    lateinit var country: CountryEntity

    @OneToMany(mappedBy = "city")
    var suitcases: MutableSet<SuitcaseEntity> = mutableSetOf()

    constructor(name: String): this() {
        this.name = name
    }

}
