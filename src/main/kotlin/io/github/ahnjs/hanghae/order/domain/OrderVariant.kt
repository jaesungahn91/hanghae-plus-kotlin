package io.github.ahnjs.hanghae.order.domain

class OrderVariant(
    val variantId: Long,
    val price: Double,
    val quantity: Int,
) {
    init {
        require(quantity > 0) { "Order variants must have a quantity greater than 0" }
    }

    companion object {
        fun create(
            variantId: Long,
            price: Double,
            quantity: Int,
        ) = OrderVariant(
            variantId = variantId,
            price = price,
            quantity = quantity,
        )

        fun fixture(
            variantId: Long = 1L,
            price: Double = 3000.0,
            quantity: Int = 1,
        ): OrderVariant {
            return OrderVariant(
                variantId = variantId,
                price = price,
                quantity = quantity,
            )
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as OrderVariant

        return variantId == other.variantId
    }

    override fun hashCode(): Int {
        return variantId.hashCode()
    }
}
