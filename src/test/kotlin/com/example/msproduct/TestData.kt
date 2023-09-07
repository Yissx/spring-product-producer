package com.example.msproduct

import com.example.msproduct.dto.ProductDto
import com.example.msproduct.entity.ProductEntity
import org.springframework.data.jpa.domain.AbstractPersistable_.id

open class TestData {
    fun msProduct() : ProductEntity {
        return ProductEntity().apply{
            id = 1
            name = "Jabon"
            price = 35.76
            description = "description"
        }
    }
    fun msProductList() : List<ProductEntity> {
        return listOf(
            ProductEntity().apply{
                    id = 1
                    name = "Jabon"
                    price = 35.76
                    description = "description"
            },
            ProductEntity().apply{
                    id = 1
                    name = "Jabon"
                    price = 35.76
                    description = "description"
            },
            ProductEntity().apply{
                    id = 1
                    name = "Jabon"
                    price = 35.76
                    description = "description"
            })
    }

}