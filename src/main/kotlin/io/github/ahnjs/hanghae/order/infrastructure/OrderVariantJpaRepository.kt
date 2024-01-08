package io.github.ahnjs.hanghae.order.infrastructure

import io.github.ahnjs.hanghae.order.domain.OrderVariant
import io.github.ahnjs.hanghae.order.domain.repository.OrderVariantRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
class OrderVariantJpaRepository(
    private val orderVariantEntityRepository: OrderVariantEntityRepository,
) : OrderVariantRepository {

}

interface OrderVariantEntityRepository : JpaRepository<OrderVariantEntity, Long>

fun OrderVariant.toEntity(order: OrderEntity): OrderVariantEntity {
    return OrderVariantEntity(
        order = order,
        quantity = this.quantity,
        price = this.price,
        variantId = this.variantId,
    )
}
