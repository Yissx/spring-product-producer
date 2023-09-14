package com.example.msproduct.service.imp

import com.example.msproduct.dto.ClientDto
import com.example.msproduct.dto.OrderDto
import com.example.msproduct.entity.ClientEntity
import com.example.msproduct.entity.OrderEntity
import com.example.msproduct.errors.EntityNotFoundException
import com.example.msproduct.mapper.ClientMapper
import com.example.msproduct.mapper.OrderMapper
import com.example.msproduct.repository.ClientRepository
import com.example.msproduct.repository.OrderRepository
import com.example.msproduct.service.OrderService
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.stereotype.Service

@Service
class OrderServiceImp(
    private val orderRepository: OrderRepository,
    private val clientServiceImp: ClientServiceImp,
    private val orderMapper : OrderMapper,
    private val clientMapper: ClientMapper
) : OrderService{

    override fun create(orderDto: OrderDto): OrderDto {
        val client = clientServiceImp.findById(orderDto.clientId!!)

            val orderEntity = orderMapper.toEntity(orderDto)
            orderEntity.client = clientMapper.toEntity(client)
            val response = orderRepository.save(orderEntity)
            return toDto(response)


    }

    override fun findAll(): List<OrderDto> {
        val response = orderRepository.findAll()
        return orderMapper.toDto(response)
    }

    override fun findById(id: Long): OrderDto {
        val response = orderRepository.findById(id).orElseThrow{
            EntityNotFoundException("Non-existent entity order with id $id")
        }
        return toDto(response)
    }

    override fun update(orderDto: OrderDto, id: Long): OrderDto {
        TODO("Not yet implemented")
        /*val entity = orderRepository.findById(id).orElseThrow{
            EntityNotFoundException("Non existent entity order with id $id")
        }*/
    }

    override fun delete(id: Long) {
        orderRepository.deleteById(id)
    }
    fun toDto(orderEntity: OrderEntity) : OrderDto {
        return orderEntity.let {
            OrderDto(
                id = it.id,
                orderDate = it.orderDate,
                clientId = it.client!!.id
            )
        }
    }
    fun toEntity(orderDto: OrderDto, clientDto: ClientDto) : OrderEntity {
        return orderDto.let {
            OrderEntity(
                orderDate = orderDto.orderDate,
                client = clientMapper.toEntity(clientDto)
            )
        }
    }

}