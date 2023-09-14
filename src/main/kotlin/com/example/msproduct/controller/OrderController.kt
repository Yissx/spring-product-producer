package com.example.msproduct.controller

import com.example.msproduct.dto.OrderDto
import com.example.msproduct.service.imp.OrderServiceImp
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
class OrderController (private val orderServiceImp: OrderServiceImp){

    @GetMapping
    fun findAll() : List<OrderDto>
        = orderServiceImp.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id : Long) : OrderDto
        = orderServiceImp.findById(id)

    @PostMapping
    fun create(@RequestBody orderDto: OrderDto) : OrderDto
        = orderServiceImp.create(orderDto)
}