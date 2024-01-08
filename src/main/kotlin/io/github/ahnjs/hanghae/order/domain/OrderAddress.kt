package io.github.ahnjs.hanghae.order.domain

import jakarta.persistence.Embeddable

@Embeddable
class OrderAddress(
    val name: String = "",
    val phone: String = "",
    val address: String = "",
)
