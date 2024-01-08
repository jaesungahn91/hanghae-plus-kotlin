package io.github.ahnjs.hanghae.order.application

import io.github.ahnjs.hanghae.order.application.component.OrderManager
import io.github.ahnjs.hanghae.order.domain.Order
import io.github.ahnjs.hanghae.order.domain.OrderCreateSpec
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderManager: OrderManager,
) {
    fun create(spec: OrderCreateSpec): Order {
        return orderManager.place(Order(spec))
    }
}
