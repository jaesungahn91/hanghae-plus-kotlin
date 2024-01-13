package io.github.ahnjs.hanghae.order.domain

class OrderProduct(
    val orderId: Long,
    val productId: Long,
    val price: Double,
    val quantity: Int,
) {
    init {
        require(quantity > 0) { "Order products must have a quantity greater than 0" }
    }

    companion object {
        fun create(
            orderId: Long,
            productId: Long,
            price: Double,
            quantity: Int,
        ) = OrderProduct(
            orderId = orderId,
            productId = productId,
            price = price,
            quantity = quantity,
        )

        fun fixture(
            orderId: Long = 1L,
            productId: Long = 1L,
            price: Double = 3000.0,
            quantity: Int = 1,
        ): OrderProduct {
            return OrderProduct(
                orderId = orderId,
                productId = productId,
                price = price,
                quantity = quantity,
            )
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as OrderProduct

        return productId == other.productId
    }

    override fun hashCode(): Int {
        return productId.hashCode()
    }
}
