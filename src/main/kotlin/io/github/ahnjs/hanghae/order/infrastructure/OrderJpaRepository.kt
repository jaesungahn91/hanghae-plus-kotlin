package io.github.ahnjs.hanghae.order.infrastructure

import io.github.ahnjs.hanghae.order.domain.Order
import io.github.ahnjs.hanghae.order.domain.repository.OrderRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
class OrderJpaRepository(
    private val orderEntityRepository: OrderEntityRepository,
    private val orderProductEntityRepository: OrderProductEntityRepository,
) : OrderRepository {

    override fun save(order: Order): Order {
        val createdOrder = orderEntityRepository.save(order.toEntity())
        val createdOrderProducts =
            orderProductEntityRepository.saveAll(createdOrder.toDomain().orderProducts.map { it.toEntity(createdOrder) })
        createdOrder.addOrderProducts(createdOrderProducts)
        return createdOrder.toDomain()
    }

}

interface OrderEntityRepository : JpaRepository<OrderEntity, Long> {

}

fun Order.toEntity(): OrderEntity {
    return OrderEntity(
        orderProducts = mutableListOf(),
        customerId = this.customerId,
        status = this.status,
        customerAddress = this.customerAddress,
    )
}
