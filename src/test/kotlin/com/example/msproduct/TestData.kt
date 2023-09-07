package com.example.msproduct

import com.example.msproduct.dto.ProductDto
import com.example.msproduct.entity.ProductEntity

open class TestData {
    fun msProduct() : ProductEntity {
        return ProductEntity().apply{
            id = 1
            name = "Jabon"
            price = 35.76
            description = "description"
        }
    }

}