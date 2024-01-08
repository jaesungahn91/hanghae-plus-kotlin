package io.github.ahnjs.hanghae.order.application.component

import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Component
class ProductReader {

}

@Component
class ProductWriter {

    fun decrease(productOptionId: Long, amount: Int) {

    }

}

@Repository
interface ProductRepository {

}
