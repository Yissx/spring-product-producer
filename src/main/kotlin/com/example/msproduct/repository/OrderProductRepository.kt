package com.example.msproduct.repository

import com.example.msproduct.entity.OrderProductEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface OrderProductRepository : JpaRepository<OrderProductEntity, UUID>{

}