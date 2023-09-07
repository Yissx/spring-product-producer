package com.example.msproduct.mapper

import com.example.msproduct.dto.ProductDto
import com.example.msproduct.entity.ProductEntity
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget
import org.mapstruct.NullValueCheckStrategy
import org.mapstruct.NullValuePropertyMappingStrategy
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
interface ProductMapper{
    fun toDto(productEntity: ProductEntity) : ProductDto

    fun toDto(productEntities: List<ProductEntity>) : List<ProductDto>

    fun toEntity(productDto: ProductDto) : ProductEntity

    fun updateEntity(productDto: ProductDto, @MappingTarget productEntity : ProductEntity)
}