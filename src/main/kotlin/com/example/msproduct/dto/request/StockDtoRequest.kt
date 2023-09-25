package com.example.msproduct.dto.request

import jakarta.validation.constraints.NotNull

data class StockDtoRequest(
    @NotNull
    var stock : Int = 0
)