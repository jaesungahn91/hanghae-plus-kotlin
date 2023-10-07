package io.github.ahnjs.hanghae.product.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class ProductTest {

    val product = Product("상품", 3);

    @Test
    fun `구매 수량은 상품의 갯수를 초과할 수 없다`() {
        // given
        var quntity = 4;

        // when & then
        assertThatThrownBy {
            product.buying(4)
        }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
    }
}

