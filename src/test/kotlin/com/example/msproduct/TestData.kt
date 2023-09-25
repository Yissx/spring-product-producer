package com.example.msproduct

import com.example.msproduct.dto.response.ProductDto
import com.example.msproduct.entity.ProductEntity
import java.util.UUID

open class TestData {
    fun msProduct() : ProductEntity {
        return ProductEntity().apply{
            id = UUID.randomUUID()
            name = "name"
            price = 35.76
            description = "description"
        }
    }
    fun msProductList() : List<ProductEntity> {
        return listOf(
            ProductEntity().apply{
                id = UUID.randomUUID()
                name = "name"
                price = 35.76
                description = "description"
            },
            ProductEntity().apply{
                id = UUID.randomUUID()
                name = "name"
                price = 35.76
                description = "description"
            },
            ProductEntity().apply{
                id = UUID.randomUUID()
                name = "name"
                price = 35.76
                description = "description"
            })
    }
    fun msProductDto() : ProductDto {
        return ProductDto().apply{
            id = UUID.randomUUID()
            name = "name"
            price = 35.76
            description = "description"
        }
    }
}