package io.github.ahnjs.hanghae.order.infrastructure

import io.github.ahnjs.hanghae.order.domain.OrderProduct
import jakarta.persistence.*
import jakarta.persistence.FetchType.LAZY

@Entity
@Table(name = "order_products")
class OrderProductEntity(
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @ManyToOne(fetch = LAZY)
    val order: OrderEntity,

    @Column(nullable = false)
    val productId: Long,

    val price: Double,

    val quantity: Int,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    fun toDomain(): OrderProduct {
        return OrderProduct.fixture()
    }
}
