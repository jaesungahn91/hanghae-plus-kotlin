package io.github.ahnjs.hanghae.order.infrastructure

import io.github.ahnjs.hanghae.order.domain.OrderProduct
import io.github.ahnjs.hanghae.order.domain.repository.OrderProductRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
class OrderProductJpaRepository(
    private val orderProductEntityRepository: OrderProductEntityRepository,
) : OrderProductRepository {
}

interface OrderProductEntityRepository : JpaRepository<OrderProductEntity, Long> {

}

fun OrderProduct.toEntity(order: OrderEntity): OrderProductEntity {
    return OrderProductEntity(
        order = order,
        quantity = this.quantity,
        price = this.price,
        productId = this.productId,
    )
}
