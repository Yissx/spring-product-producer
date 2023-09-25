package com.example.msproduct.mapper

import com.example.msproduct.dto.response.StockDto
import com.example.msproduct.dto.request.StockDtoRequestCreate
import com.example.msproduct.entity.StockEntity
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.mapstruct.NullValueCheckStrategy
import org.mapstruct.NullValuePropertyMappingStrategy
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
interface StockMapper {

    fun toEntity(stockDto: StockDtoRequestCreate) : StockEntity

    @Mappings(value = [Mapping(source = "product.id", target = "productId")])
    fun toDto(stockEntity: StockEntity) : StockDto

    @Mappings(value = [Mapping(source = "product.id", target = "productId")])
    fun toDto(stockEntities: List<StockEntity>) : List<StockDto>
}