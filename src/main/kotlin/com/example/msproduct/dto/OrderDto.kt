package com.example.msproduct.dto

import java.time.LocalDateTime
import java.util.UUID

data class OrderDto (
    var id : UUID? = null,

    var orderDate : LocalDateTime? = null,

    var clientId : UUID? = null,

    //var products : List<UUID>? = null
)