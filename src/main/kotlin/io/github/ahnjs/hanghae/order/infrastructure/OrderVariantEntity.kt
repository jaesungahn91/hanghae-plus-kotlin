package io.github.ahnjs.hanghae.order.infrastructure

import io.github.ahnjs.hanghae.order.domain.OrderVariant
import jakarta.persistence.*
import jakarta.persistence.FetchType.LAZY

@Entity
class OrderVariantEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @ManyToOne(fetch = LAZY)
    val order: OrderEntity,

    @Column(nullable = false)
    val variantId: Long,

    val price: Double,

    val quantity: Int,
) {

    fun toDomain(): OrderVariant {
        return OrderVariant.fixture()
    }

}
