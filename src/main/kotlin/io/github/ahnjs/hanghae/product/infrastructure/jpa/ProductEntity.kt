package io.github.ahnjs.hanghae.product.infrastructure.jpa;

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "products")
class ProductEntity(
    val name: String,
    val quantity: Int,
) {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null
}
