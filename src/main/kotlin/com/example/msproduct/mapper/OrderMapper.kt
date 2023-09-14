package com.example.msproduct.mapper

import com.example.msproduct.dto.ClientDto
import com.example.msproduct.dto.OrderDto
import com.example.msproduct.entity.ClientEntity
import com.example.msproduct.entity.OrderEntity
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingTarget
import org.mapstruct.Mappings
import org.mapstruct.NullValueCheckStrategy
import org.mapstruct.NullValuePropertyMappingStrategy
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
interface OrderMapper {

    fun toEntity(orderDto: OrderDto) : OrderEntity

    @Mappings(value=[
        Mapping(source = "client.id", target = "clientId")
    ])
    fun toDto(orderEntity: OrderEntity) : OrderDto

    fun toDto(orderEntities: List<OrderEntity>) : List<OrderDto>


}