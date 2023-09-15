package com.example.msproduct.repository

import com.example.msproduct.entity.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ProductRepository : JpaRepository<ProductEntity, UUID>{
    @Query(value = "SELECT * FROM product WHERE name like :search or description like :search", nativeQuery = true)
    fun findByNameOrDescriptionContaining(@Param("search") search : String) : List<ProductEntity>

}