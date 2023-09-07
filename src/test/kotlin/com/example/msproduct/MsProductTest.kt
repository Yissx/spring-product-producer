package com.example.msproduct

import com.example.msproduct.repository.ProductRepository
import com.example.msproduct.repository.ProductRepositoryService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.junit.jupiter.MockitoSettings
import org.mockito.quality.Strictness
import java.util.*
import org.junit.jupiter.api.Test

@ExtendWith(MockitoExtension::class)
@MockitoSettings(strictness = Strictness.LENIENT)
class MsProductTest : TestData(){

    @InjectMocks
    private lateinit var productRepositoryService : ProductRepositoryService

    @Mock
    private lateinit var productRepository : ProductRepository

    @Test
    fun `find all`(){

    }

    @Test
    fun `find by id`(){
        val entity = msProduct()
        Mockito.`when`(productRepository.findById(entity.id!!)).thenReturn(
            Optional.of(entity)
        )
        val response = productRepositoryService.getById(entity.id!!)
        Mockito.verify(productRepository).findById(entity.id!!)
        Assertions.assertThat(entity.id).isEqualTo(response.id)
    }
    @Test
    fun `find by id not found`(){

    }

    @Test
    fun `create`(){

    }

    @Test
    fun `update`(){

    }

    @Test
    fun `delete`(){

    }
}