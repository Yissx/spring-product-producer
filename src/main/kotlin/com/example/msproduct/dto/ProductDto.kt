package com.example.msproduct.dto

import java.util.UUID

data class ProductDto (
    var id: UUID? = null,

    var name: String? = null,

    var price: Double? = null,

    var description: String? = null
)