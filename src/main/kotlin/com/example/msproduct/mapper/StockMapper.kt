package com.example.msproduct.mapper

import com.example.msproduct.dto.StockDto
import com.example.msproduct.entity.StockEntity
import org.mapstruct.Mapper
import org.mapstruct.NullValueCheckStrategy
import org.mapstruct.NullValuePropertyMappingStrategy
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
interface StockMapper {

    fun toEntity(stockDto: StockDto) : StockEntity

    fun toDto(stockEntity: StockEntity) : StockDto
}