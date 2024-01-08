package io.github.ahnjs.hanghae.order.domain

enum class OrderStatus {

    PENDING_PAYMENT,
    PENDING_SHIPMENT,
    START_SHIPPING,
    DELIVERED,
    CANCELED,
    ;

    companion object {
        fun fixture(): OrderStatus {
            return PENDING_PAYMENT
        }
    }

}
