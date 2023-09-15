package com.example.msproduct.dto

import java.util.UUID

data class OrderProductDto(
    var id : UUID? = null,

    var productId : UUID? = null,

    var orderId : UUID? = null
)
