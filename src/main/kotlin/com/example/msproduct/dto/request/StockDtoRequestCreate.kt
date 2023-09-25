package com.example.msproduct.dto.request

import com.example.msproduct.entity.ProductEntity
import jakarta.validation.constraints.NotNull

data class StockDtoRequestCreate (
    @NotNull
    var product : ProductEntity? = null
)