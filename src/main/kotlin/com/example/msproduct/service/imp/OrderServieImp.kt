package com.example.msproduct.service.imp

import com.example.msproduct.dto.OrderDto
import com.example.msproduct.entity.ClientEntity
import com.example.msproduct.errors.EntityNotFoundException
import com.example.msproduct.mapper.ClientMapper
import com.example.msproduct.mapper.OrderMapper
import com.example.msproduct.repository.ClientRepository
import com.example.msproduct.repository.OrderRepository
import com.example.msproduct.service.OrderService
import org.springframework.stereotype.Service

@Service
class OrderServiceImp(
    private val orderRepository: OrderRepository,
    private val clientServiceImp: ClientServiceImp,
    private val orderMapper : OrderMapper,
    private val clientMapper: ClientMapper
) : OrderService{

    override fun create(orderDto: OrderDto): OrderDto {
        val client = clientServiceImp.findById(orderDto.client_id!!)
        val clientEntity = clientMapper.toEntity(client)
        if(clientEntity != null){
            val entity = orderMapper.toEntity(orderDto, clientEntity)
            val response = orderRepository.save(entity)
            return orderMapper.toDto(response)
        }
        else{
            throw EntityNotFoundException("Non-existent client with id ${orderDto.client_id}")
        }
    }

    override fun findAll(): List<OrderDto> {
        val response = orderRepository.findAll()
        return orderMapper.toDto(response)
    }

    override fun findById(id: Long): OrderDto {
        TODO("Not yet implemented")
    }

    override fun update(orderDto: OrderDto, id: Long): OrderDto {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }
}