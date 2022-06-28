package pl.pja.infrastructure.entities

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "Suitcase")
class SuitcaseEntity() {

    @Id
    @Column(name = "IdSuitcase")
    var id: String = UUID.randomUUID().toString()

    @Column(name = "Name", nullable = false)
    var name: String = ""

    @ManyToMany(cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinTable(
        name = "Suitcase_Item",
        joinColumns = [JoinColumn(name = "FK_IdSuitcase", referencedColumnName = "IdSuitcase")],
        inverseJoinColumns = [JoinColumn(name = "FK_IdItem", referencedColumnName = "IdItem")]
    )
    var items: MutableSet<ItemEntity> = mutableSetOf()

    @ManyToOne(cascade = [CascadeType.MERGE, CascadeType.PERSIST])
    @JoinColumn(name = "IdCity", nullable = false)
    lateinit var city: CityEntity

    constructor(name: String): this() {
        this.name = name
    }

}
