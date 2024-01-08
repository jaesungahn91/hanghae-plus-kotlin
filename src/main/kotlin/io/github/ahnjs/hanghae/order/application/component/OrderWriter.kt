package io.github.ahnjs.hanghae.order.application.component

import io.github.ahnjs.hanghae.order.domain.Order
import io.github.ahnjs.hanghae.order.domain.repository.OrderRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class OrderWriter(
    private val orderRepository: OrderRepository,
) {

    @Transactional
    fun create(order: Order): Order {
        return orderRepository.save(order)
    }

}
