package com.example.msproduct.service

import com.example.msproduct.dto.ProductDto

interface ProductService {
    fun create(productDto: ProductDto) : ProductDto

    fun get() : List<ProductDto>

    fun getById(id : Long) : ProductDto

    fun search(search : String) : List<ProductDto>

    fun update(productDto: ProductDto, id : Long) : ProductDto

    fun delete(id : Long)
}