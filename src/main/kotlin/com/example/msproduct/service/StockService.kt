package com.example.msproduct.service

import com.example.msproduct.dto.StockDto
import java.util.UUID

interface StockService {

    fun create(stockDto: StockDto)

    fun update(stockDto: StockDto, id : UUID) : StockDto

}