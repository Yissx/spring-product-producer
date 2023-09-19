package com.example.msproduct.service.imp

import com.example.msproduct.dto.OrderDto
import com.example.msproduct.entity.ProductEntity
import com.example.msproduct.errors.EntityNotFoundException
import com.example.msproduct.mapper.ClientMapper
import com.example.msproduct.mapper.OrderMapper
import com.example.msproduct.mapper.ProductMapper
import com.example.msproduct.repository.OrderRepository
import com.example.msproduct.service.OrderService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class OrderServiceImp(
    private val orderRepository: OrderRepository,
    private val clientServiceImp: ClientServiceImp,
    private val orderMapper : OrderMapper,
    private val clientMapper: ClientMapper,
    private val productServiceImp: ProductServiceImp,
    private val productMapper: ProductMapper
) : OrderService{

    override fun create(orderDto: OrderDto): OrderDto {
        val client = clientMapper.toEntity(clientServiceImp.findById(orderDto.clientId!!))
        val products : List<ProductEntity> = orderDto.products!!.map {
            productMapper.toEntity(productServiceImp.findById(it))
        }
        val orderEntity = orderMapper.toEntity(orderDto, products, client)
        val response = orderRepository.save(orderEntity)
        return orderMapper.toDto(response)
    }

    override fun findAll(): List<OrderDto> {
        val response = orderRepository.findAll()
        return response.map {
            orderMapper.toDto(it)
        }
    }

    override fun findById(id: UUID): OrderDto {
        val response = orderRepository.findById(id).orElseThrow{
            EntityNotFoundException("Non-existent entity order with id $id")
        }
        return orderMapper.toDto(response)
    }

    override fun addProduct(orderDto: OrderDto, id: UUID): OrderDto {
        val order = orderRepository.findById(id).orElseThrow{
            EntityNotFoundException("Non-existent entity order with id $id")
        }
        val productsToBeAdded : List<ProductEntity> = orderDto.products!!.map {
            productMapper.toEntity(productServiceImp.findById(it))
        }
        order.products = order.products!!.plus(productsToBeAdded)
        val response = orderRepository.save(order)
        return orderMapper.toDto(response)
    }
    override fun deleteProduct(orderDto: OrderDto, id: UUID): OrderDto {
        val order = orderRepository.findById(id).orElseThrow{
            EntityNotFoundException("Non-existent entity order with id $id")
        }
        order.products = order.products!!.filter {
            !orderDto.products!!.contains(it.id)
        }
        val response = orderRepository.save(order)
        return orderMapper.toDto(response)
    }

    override fun delete(id: UUID) {
        orderRepository.deleteById(id)
    }
}