package com.example.msproduct.dto.request

import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime
import java.util.UUID

data class OrderDtoRequestCreate (
    @NotNull
    var orderDate : LocalDateTime? = null,

    @NotNull
    var clientId : UUID? = null,

)