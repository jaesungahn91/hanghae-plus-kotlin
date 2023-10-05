package io.github.ahnjs.hanghae.product.domain

class Product(
    var name: String,
    var quantity: Int
) {

    fun buying(quantity: Int) {
        require(this.quantity - quantity >= 0)
    }
}
