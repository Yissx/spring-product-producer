package com.example.msproduct.service

import com.example.msproduct.dto.response.ProductDto
import java.util.UUID

interface ProductService {
    fun create(productDto: ProductDto) : ProductDto

    fun findAll() : List<ProductDto>

    fun findById(id : UUID) : ProductDto

    fun search(search : String) : List<ProductDto>

    fun update(productDto: ProductDto, id : UUID) : ProductDto

    fun delete(id : UUID)
}