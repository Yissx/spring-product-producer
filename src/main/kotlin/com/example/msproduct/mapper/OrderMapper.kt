package com.example.msproduct.mapper

import com.example.msproduct.dto.request.OrderDtoRequest
import com.example.msproduct.dto.response.OrderDto
import com.example.msproduct.dto.request.OrderDtoRequestCreate
import com.example.msproduct.entity.ClientEntity
import com.example.msproduct.entity.OrderEntity
import org.springframework.stereotype.Service

@Service
class OrderMapper {

    fun toDto(orderEntity: OrderEntity) : OrderDto {
        return orderEntity.let {
            OrderDto(
                id = it.id,
                orderDate = it.orderDate,
                clientId = it.client!!.id,
                products = if(it.products != null) it.products!!.map { product -> product.id } else emptyList(),
                status = it.status
            )
        }
    }

    fun toEntity(orderDto: OrderDtoRequestCreate, clientEntity : ClientEntity) : OrderEntity {
        return orderDto.let {
            OrderEntity(
                orderDate = it.orderDate,
                client = clientEntity
            )
        }
    }

    fun update(orderDto: OrderDtoRequest, orderEntity: OrderEntity) : OrderEntity {
        if(orderDto == null){
            return OrderEntity()
        }
        else{
            if(orderDto.orderDate != null){
                orderEntity.orderDate = orderDto.orderDate
            }
            if (orderDto.status != null){
                orderEntity.status = orderDto.status
            }
            return orderEntity
        }
    }
}