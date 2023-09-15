package com.example.msproduct.service

import com.example.msproduct.dto.OrderDto
import java.util.UUID

interface OrderService {
    fun create(orderDto: OrderDto) : OrderDto

    fun findAll() : List<OrderDto>

    fun findById(id : UUID) : OrderDto

    fun update(orderDto: OrderDto, id : UUID) : OrderDto

    fun delete(id : UUID)
}