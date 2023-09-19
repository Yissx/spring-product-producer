package com.example.msproduct.mapper

import com.example.msproduct.dto.OrderDto
import com.example.msproduct.entity.ClientEntity
import com.example.msproduct.entity.OrderEntity
import com.example.msproduct.entity.ProductEntity
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.stereotype.Service

/*@Mapper(componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)*/
@Service
class OrderMapper {

    fun toDto(orderEntity: OrderEntity) : OrderDto {
        return orderEntity.let {
            OrderDto(
                id = it.id,
                orderDate = it.orderDate,
                clientId = it.client!!.id,
                products = it.products!!.map {product ->
                    product.id
                }
            )
        }
    }
    fun toEntity(orderDto: OrderDto, productEntities : List<ProductEntity>, clientEntity : ClientEntity) : OrderEntity {
        return orderDto.let {
            OrderEntity(
                orderDate = it.orderDate,
                client = clientEntity,
                products = productEntities
            )
        }
    }
}