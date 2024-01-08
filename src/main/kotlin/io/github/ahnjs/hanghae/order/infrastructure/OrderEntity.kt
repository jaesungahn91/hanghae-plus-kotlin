package io.github.ahnjs.hanghae.order.infrastructure

import io.github.ahnjs.hanghae.order.domain.Order
import io.github.ahnjs.hanghae.order.domain.OrderAddress
import io.github.ahnjs.hanghae.order.domain.OrderStatus
import jakarta.persistence.*
import jakarta.persistence.GenerationType.IDENTITY

@Entity
class OrderEntity(
    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
    val orderVariants: MutableList<OrderVariantEntity>,

    val customerId: Long,

    @Embedded
    val customerAddress: OrderAddress,

    @Enumerated(EnumType.STRING)
    val status: OrderStatus,
) {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null

    fun toDomain(): Order {
        return Order.fixture()
    }

    fun addOrderVariants(orderVariants: MutableList<OrderVariantEntity>) {
        this.orderVariants.addAll(orderVariants)
    }

}
