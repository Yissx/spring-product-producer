package com.example.msproduct.dto

import com.example.msproduct.entity.ClientEntity
import java.util.Date

data class OrderDto (
    var id : Long? = null,

    var order_date : Date? = null,

    var client_id : Long? = null
)