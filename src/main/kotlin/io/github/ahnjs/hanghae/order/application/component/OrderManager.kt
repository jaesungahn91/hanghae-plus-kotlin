package io.github.ahnjs.hanghae.order.application.component

import io.github.ahnjs.hanghae.order.domain.Order
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class OrderManager(
    private val orderWriter: OrderWriter,
    private val productWriter: ProductWriter,
) {

    @Transactional
    fun place(order: Order): Order {
        val createdOrder = orderWriter.create(order)
        createdOrder.orderProducts.forEach {
            productWriter.decrease(it.productId, it.quantity)
        }
        return createdOrder
    }

}
