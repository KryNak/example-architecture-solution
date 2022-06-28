package pl.pja.infrastructure.entities

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "Item")
class ItemEntity {

    @Id
    @Column(name = "IdItem")
    var id: String = UUID.randomUUID().toString()

    @Column(name = "Name", nullable = false)
    var name: String = ""

    @Column(name = "Quantity", nullable = false)
    var quantity: Int = 0

    @Column(name = "IsPacked", columnDefinition = "bit", nullable = false)
    var isPacked: Boolean = false

    @ManyToMany(mappedBy = "items")
    var suitcases: MutableSet<SuitcaseEntity> = mutableSetOf()

}
