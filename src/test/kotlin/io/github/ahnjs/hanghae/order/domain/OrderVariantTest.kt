package io.github.ahnjs.hanghae.order.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class OrderVariantTest {

    @Test
    fun `주문 품목의 수량이 0이하일 경우 예외 발생`() {
        // given
        val quantity = 0

        // when & then
        assertThatThrownBy { OrderVariant.fixture(quantity = quantity) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `주문 품목 생성`() {
        // given
        val variantId = 1L

        // when
        val orderVariant = OrderVariant.fixture(variantId = variantId)

        // then
        assertThat(orderVariant.variantId).isEqualTo(variantId)
    }
}
