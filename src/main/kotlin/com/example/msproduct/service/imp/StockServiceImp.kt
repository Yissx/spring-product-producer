package com.example.msproduct.service.imp

import com.example.msproduct.dto.StockDto
import com.example.msproduct.errors.EntityNotFoundException
import com.example.msproduct.mapper.StockMapper
import com.example.msproduct.repository.StockRepository
import com.example.msproduct.service.StockService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class StockServiceImp(
    private val stockMapper: StockMapper,
    private val stockRepository : StockRepository
) : StockService{

    override fun create(stockDto: StockDto) {
        println(stockDto)
        val entity = stockMapper.toEntity(stockDto)
        val x = stockRepository.save(entity)
    }

    override fun update(stockDto: StockDto, id: UUID): StockDto {
        val entity = stockRepository.findById(id).orElseThrow { EntityNotFoundException("") }
        entity.stock += stockDto.stock
        val response = stockRepository.save(entity)
        return stockMapper.toDto(response)
    }

}