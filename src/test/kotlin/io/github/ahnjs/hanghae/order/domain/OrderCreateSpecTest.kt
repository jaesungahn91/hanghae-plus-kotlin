package io.github.ahnjs.hanghae.order.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OrderCreateSpecTest {

    @Test
    fun `주문 품목이 비어 있는 경우 예외 발생`() {
        // given
        val orderProducts = mutableListOf<OrderProduct>()

        // when & then
        Assertions.assertThatThrownBy { Order.fixture(orderProducts = orderProducts) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `주문 생성`() {
        // given
        val orderId = 1L;

        // when
        val order = Order.fixture(id = orderId)

        // then
        assertThat(order.id).isEqualTo(orderId)
    }
}
