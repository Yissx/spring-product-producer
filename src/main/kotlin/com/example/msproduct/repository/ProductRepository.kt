package com.example.msproduct.repository

import com.example.msproduct.entity.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface ProductRepository : JpaRepository<ProductEntity, Long>{
    @Query(value = "SELECT * FROM product WHERE name like :name", nativeQuery = true)
    fun findByNameContaining(@Param("name") name : String) : List<ProductEntity>
}