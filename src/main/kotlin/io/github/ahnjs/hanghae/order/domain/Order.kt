package io.github.ahnjs.hanghae.order.domain

import io.github.ahnjs.hanghae.order.domain.OrderStatus.PENDING_PAYMENT

class Order(
    val id: Long? = null,
    val customerId: Long,
    val orderVariants: MutableList<OrderVariant>,
    val customerAddress: OrderAddress,
    val status: OrderStatus = PENDING_PAYMENT,
) {

    init {
        require(orderVariants.isNotEmpty()) { "Order must have at least one variant" }
    }

    constructor(spec: OrderCreateSpec) : this(
        customerId = spec.customerId,
        orderVariants = spec.orderVariants,
        customerAddress = spec.customerAddress,
    )

    companion object {
        fun fixture(
            customerId: Long = 1L,
            orderVariants: MutableList<OrderVariant> = mutableListOf(OrderVariant.fixture()),
            customerAddress: OrderAddress = OrderAddress(),
            id: Long? = null,
        ): Order {
            return Order(
                id = id,
                customerId = customerId,
                orderVariants = orderVariants,
                customerAddress = customerAddress,
            )
        }
    }

    fun addOrderVariants(orderVariants: MutableList<OrderVariant>) {
        this.orderVariants.addAll(orderVariants)
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
    val orderVariants: MutableList<OrderVariant>,
    val customerAddress: OrderAddress,
)
