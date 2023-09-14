package com.example.msproduct.service

import com.example.msproduct.dto.OrderDto

interface OrderService {
    fun create(orderDto: OrderDto) : OrderDto

    fun findAll() : List<OrderDto>

    fun findById(id : Long) : OrderDto

    fun update(orderDto: OrderDto, id : Long) : OrderDto

    fun delete(id : Long)
}