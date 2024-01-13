package io.github.ahnjs.hanghae.order.persistence

import io.github.ahnjs.hanghae.order.application.OrderService
import io.github.ahnjs.hanghae.order.domain.Order
import io.github.ahnjs.hanghae.order.domain.OrderAddress
import io.github.ahnjs.hanghae.order.domain.OrderCreateSpec
import io.github.ahnjs.hanghae.order.domain.OrderProduct
import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController(
    private val orderService: OrderService
) {

    @ResponseStatus(CREATED)
    @PostMapping("/orders")
    fun postOrder(@RequestBody request: OrderPostRequest): Order {
        return orderService.create(request.toOrderCreateSpec())
    }

}

data class OrderPostRequest(
    val customerId: Long,
    val orderProducts: MutableList<OrderProduct>,
    val customerAddress: OrderAddress,
) {
    fun toOrderCreateSpec(): OrderCreateSpec {
        return OrderCreateSpec(
            customerId = customerId,
            orderProducts = orderProducts,
            customerAddress = customerAddress,
        )
    }
}

