package io.github.ahnjs.hanghae.order.infrastructure

import io.github.ahnjs.hanghae.order.domain.Order
import io.github.ahnjs.hanghae.order.domain.OrderAddress
import io.github.ahnjs.hanghae.order.domain.OrderStatus
import jakarta.persistence.*
import jakarta.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "orders")
class OrderEntity(
    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
    val orderProducts: MutableList<OrderProductEntity>,

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

    fun addOrderProducts(orderProduct: MutableList<OrderProductEntity>) {
        this.orderProducts.addAll(orderProduct)
    }

}
