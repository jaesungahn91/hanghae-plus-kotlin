package io.github.ahnjs.hanghae.order.domain

import io.github.ahnjs.hanghae.order.domain.OrderStatus.PENDING_PAYMENT

class Order(
    val id: Long? = null,
    val customerId: Long,
    val orderProducts: MutableList<OrderProduct>,
    val customerAddress: OrderAddress,
    val status: OrderStatus = PENDING_PAYMENT,
) {

    init {
        require(orderProducts.isNotEmpty()) { "Order must have at least one product" }
    }

    constructor(spec: OrderCreateSpec) : this(
        customerId = spec.customerId,
        orderProducts = spec.orderProducts,
        customerAddress = spec.customerAddress,
    )

    companion object {
        fun fixture(
            customerId: Long = 1L,
            orderProducts: MutableList<OrderProduct> = mutableListOf(OrderProduct.fixture()),
            customerAddress: OrderAddress = OrderAddress(),
            id: Long? = null,
        ): Order {
            return Order(
                id = id,
                customerId = customerId,
                orderProducts = orderProducts,
                customerAddress = customerAddress,
            )
        }
    }

    fun addOrderProduct(orderProducts: MutableList<OrderProduct>) {
        this.orderProducts.addAll(orderProducts)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Order

        return id == other.id
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}

data class OrderCreateSpec(
    val customerId: Long,
    val orderProducts: MutableList<OrderProduct>,
    val customerAddress: OrderAddress,
)
