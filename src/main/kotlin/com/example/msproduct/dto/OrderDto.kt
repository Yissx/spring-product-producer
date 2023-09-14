package com.example.msproduct.dto

import com.example.msproduct.entity.ClientEntity
import java.util.Date

data class OrderDto (
    var id : Long? = null,

    var orderDate : Date? = null,

    var clientId : Long? = null
)