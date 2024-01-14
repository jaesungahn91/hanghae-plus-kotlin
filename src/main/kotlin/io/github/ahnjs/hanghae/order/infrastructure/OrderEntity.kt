package io.github.ahnjs.hanghae.order.infrastructure

import io.github.ahnjs.hanghae.order.domain.Order
import io.github.ahnjs.hanghae.order.domain.OrderAddress
import io.github.ahnjs.hanghae.order.domain.OrderStatus
import jakarta.persistence.*
import jakarta.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "orders")
class OrderEntity(
    val customerId: Long,

    @Embedded
    val customerAddress: OrderAddress,

    @Enumerated(EnumType.STRING)
    val status: OrderStatus,
) {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
    val orderProducts: MutableList<OrderProductEntity> = mutableListOf()

    fun toDomain(): Order {
        return Order.fixture()
    }

    fun addOrderProducts(orderProduct: List<OrderProductEntity>) {
        this.orderProducts.addAll(orderProduct)
    }

}
