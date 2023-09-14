package com.example.msproduct

import com.example.msproduct.dto.ProductDto
import com.example.msproduct.entity.ProductEntity
import com.example.msproduct.errors.EntityNotFoundException
import com.example.msproduct.mapper.ProductMapper
import com.example.msproduct.repository.ProductRepository
import com.example.msproduct.service.imp.ProductServiceImp
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.junit.jupiter.MockitoSettings
import org.mockito.quality.Strictness
import org.junit.jupiter.api.Test
import java.util.Optional

@ExtendWith(MockitoExtension::class)
@MockitoSettings(strictness = Strictness.LENIENT)
class MsProductTest : TestData(){

    @InjectMocks
    private lateinit var productServiceImp : ProductServiceImp

    @Mock
    private lateinit var productRepository : ProductRepository
    @Mock
    private lateinit var productMapper: ProductMapper


    @Test
    fun `find all`(){
        val entities = msProductList()
        Mockito.`when`(productRepository.findAll()).thenReturn(
            entities
        )
        Mockito.`when`(productMapper.toDto(entities)).thenReturn(
            listOf(
                ProductDto().apply{
                    id = entities[0].id
                },
                ProductDto().apply{
                    id = entities[1].id
                },
                ProductDto().apply{
                    id = entities[2].id
                })
        )
        val response = productServiceImp.findAll()
        Mockito.verify(productRepository).findAll()
        Assertions.assertThat(entities.size).isEqualTo(response.size)
    }

    @Test
    fun `find by id`(){
        val entity = msProduct()
        Mockito.`when`(productRepository.findById(entity.id!!)).thenReturn(
            Optional.of(entity)
        )
        Mockito.`when`(productMapper.toDto(entity)).thenReturn(
            ProductDto().apply {
                id = entity.id
            }
        )
        val response = productServiceImp.findById(entity.id!!)
        Mockito.verify(productRepository).findById(entity.id!!)
        Assertions.assertThat(entity.id).isEqualTo(response.id)
    }
    @Test
    fun `find by id not found`(){
        val entity = msProduct()
        Mockito.`when`(productRepository.findById(entity.id!!)).thenReturn(
            Optional.empty()
        )
        Assertions.assertThatExceptionOfType(EntityNotFoundException::class.java).isThrownBy {
            productServiceImp.findById(entity.id!!)
        }
    }

    @Test
    fun `create`() {
        val dto = msProductDto()
        Mockito.`when`(productMapper.toEntity(dto)).thenReturn(
            ProductEntity().apply {
                id = dto.id
                name = dto.name
                description = dto.description
                price = dto.price
            }
        )
        val entity= msProduct()
        Mockito.`when`(productRepository.save(entity)).thenReturn(
            entity
        )
        Mockito.`when`(productMapper.toDto(entity)).thenReturn(
            ProductDto().apply {
                id = entity.id
                name = entity.name
                description = entity.description
                price = entity.price
            }
        )
        val response = productServiceImp.create(dto)
        //Mockito.verify(productRepository).save(entity)
        Assertions.assertThat(dto.name).isEqualTo(response.name)
    }

    @Test
    fun `update`(){
        val entity = msProduct()
        Mockito.`when`(productRepository.save(entity)).thenReturn(
            entity
        )
        Mockito.`when`(productRepository.findById(entity.id!!)).thenReturn(
            Optional.of(entity)
        )
        Mockito.`when`(productMapper.toDto(entity)).thenReturn(
            ProductDto().apply {
                id = entity.id
                name = entity.name
                description = "no description"
                price = entity.price
            }
        )
        val request = productMapper.toDto(entity)
        Mockito.verify(productMapper).toDto(entity)
        val response = productServiceImp.update(request, request.id!!)
        //Mockito.verify(productRepository).save(entity)
        Assertions.assertThat(entity.id).isEqualTo(response.id)
        Assertions.assertThat(entity.description).isNotEqualTo(response.description)
    }
    @Test
    fun `update not found`(){
        val entity = msProduct()
        Mockito.`when`(productMapper.toDto(entity)).thenReturn(
            ProductDto().apply {
                id = entity.id
                name = entity.name
                description = "no description"
                price = entity.price
            }
        )
        Mockito.`when`(productRepository.findById(entity.id!!)).thenThrow(
            EntityNotFoundException("exception"))

        Assertions.assertThatExceptionOfType(EntityNotFoundException::class.java).isThrownBy {
            productServiceImp.update(productMapper.toDto(entity), entity.id!!)
        }
    }

    @Test
    fun `delete`(){
        val id : Long = 1
        Mockito.doNothing().`when`(productRepository).deleteById(id)
        productServiceImp.delete(id)
        Mockito.verify(productRepository).deleteById(id)
    }
}