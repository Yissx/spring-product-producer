package com.example.msproduct.repository

import com.example.msproduct.entity.StockEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.UUID

interface StockRepository : JpaRepository<StockEntity, UUID> {

}