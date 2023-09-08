package com.example.msproduct.repository

import com.example.msproduct.dto.ProductDto
import com.example.msproduct.errors.EntityNotFoundException
import com.example.msproduct.mapper.ProductMapper
import org.springframework.stereotype.Service

@Service
class ProductRepositoryService(val productMapper : ProductMapper, val productRepository: ProductRepository) {

    fun create(productDto: ProductDto) : ProductDto {
        val entity = productMapper.toEntity(productDto)
        val response = productRepository.save(entity)
        return productMapper.toDto(response)
    }

    fun get() : List<ProductDto>{
        val entities = productRepository.findAll()
        return productMapper.toDto(entities)
    }

    fun getById(id : Long) : ProductDto {
        val response = productRepository.findById(id).orElseThrow{
            EntityNotFoundException("Non-existent id")
        }
        return productMapper.toDto(response)
    }

    fun search(search : String) : List<ProductDto> {
        val entities = productRepository.findByNameOrDescriptionContaining(search)
        return productMapper.toDto(entities)
    }

    fun update(productDto: ProductDto, id : Long) : ProductDto {
        val entity = productRepository.findById(id).orElseThrow()
        productMapper.updateEntity(productDto, entity)
        val response = productRepository.save(entity)
        return productMapper.toDto(response)
    }

    fun delete(id : Long){
        productRepository.deleteById(id)
    }
}