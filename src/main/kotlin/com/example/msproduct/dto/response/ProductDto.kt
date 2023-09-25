package com.example.msproduct.dto.response

import jakarta.validation.constraints.NotNull
import java.util.UUID

data class ProductDto (
    var id: UUID? = null,

    @NotNull
    var name: String? = null,

    @NotNull
    var price: Double? = null,

    @NotNull
    var description: String? = null
)