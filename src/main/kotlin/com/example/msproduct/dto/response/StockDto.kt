package com.example.msproduct.dto.response

import jakarta.validation.constraints.NotNull
import java.util.UUID

data class StockDto(
    var id : UUID? = null,

    @NotNull
    var productId : UUID? = null,

    @NotNull
    var stock : Int = 0
)