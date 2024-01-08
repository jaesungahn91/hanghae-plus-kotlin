package io.github.ahnjs.hanghae.order.domain.repository

import io.github.ahnjs.hanghae.order.domain.Order

interface OrderRepository {

    fun save(order: Order): Order

}
