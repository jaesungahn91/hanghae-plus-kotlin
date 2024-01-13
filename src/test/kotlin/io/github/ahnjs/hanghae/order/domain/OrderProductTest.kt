package io.github.ahnjs.hanghae.order.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class OrderProductTest {

    @Test
    fun `주문 품목의 수량이 0이하일 경우 예외 발생`() {
        // given
        val quantity = 0

        // when & then
        assertThatThrownBy { OrderProduct.fixture(quantity = quantity) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `주문 품목 생성`() {
        // given
        val productId = 1L

        // when
        val orderProduct = OrderProduct.fixture(productId = productId)

        // then
        assertThat(orderProduct.productId).isEqualTo(productId)
    }
}
