package pl.pja.infrastructure.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pl.pja.infrastructure.entities.ItemEntity

@Repository
interface ItemRepository: JpaRepository<ItemEntity, String> {
}
