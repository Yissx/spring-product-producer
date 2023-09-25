package com.example.msproduct.repository

import com.example.msproduct.entity.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface OrderRepository : JpaRepository<OrderEntity, UUID>{
    @Query(value="DELETE FROM order_product WHERE product_id = :productId AND order_id = :orderId", nativeQuery = true)
    fun deleteProductFromOrder(@Param("productId") productId : UUID, @Param("orderId") orderId : UUID)

    @Modifying
    @Query(value="INSERT INTO order_product VALUES (:orderId, :productId)", nativeQuery = true)
    fun addProductToOrder(@Param("productId") productId : UUID, @Param("orderId") orderId : UUID)
}