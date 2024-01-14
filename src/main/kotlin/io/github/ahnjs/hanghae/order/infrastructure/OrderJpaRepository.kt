package io.github.ahnjs.hanghae.order.infrastructure

import io.github.ahnjs.hanghae.order.domain.Order
import io.github.ahnjs.hanghae.order.domain.OrderProduct
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
        val createdOrderProducts = orderProductEntityRepository.saveAllAndMapToDomain(order.orderProducts, createdOrder)
        createdOrder.addOrderProducts(createdOrderProducts)
        return createdOrder.toDomain()
    }

    private fun OrderProductEntityRepository.saveAllAndMapToDomain(
        orderProducts: List<OrderProduct>,
        createdOrder: OrderEntity
    ): List<OrderProductEntity> {
        return orderProductEntityRepository.saveAll(orderProducts.map { it.toEntity(createdOrder) })
    }

}

interface OrderEntityRepository : JpaRepository<OrderEntity, Long> {

}


fun Order.toEntity(): OrderEntity {
    return OrderEntity(
        customerId = this.customerId,
        status = this.status,
        customerAddress = this.customerAddress,
    )
}
