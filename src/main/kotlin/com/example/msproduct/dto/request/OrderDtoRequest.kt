package com.example.msproduct.dto.request

import com.example.msproduct.dto.enums.OrderStatusEnum
import java.time.LocalDateTime

data class OrderDtoRequest (
    var orderDate : LocalDateTime? = null,

    var status : OrderStatusEnum? = null
)