package com.example.msproduct.controller

import com.example.msproduct.repository.ProductRepository
import com.example.msproduct.dto.ProductDto
import com.example.msproduct.mapper.ProductMapper
import com.example.msproduct.repository.ProductRepositoryService
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/product-api")
@Validated
class ProductController (val productRepositoryService: ProductRepositoryService){
    @PostMapping
    fun create(@RequestBody productDto: ProductDto) : ProductDto
        = productRepositoryService.create(productDto)

    @GetMapping
    fun get() : List<ProductDto>
        = productRepositoryService.get()

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id : Long) : ProductDto
        = productRepositoryService.getById(id)

    @GetMapping("/search/{name}")
    fun getByName(@PathVariable("name") name : String) : List<ProductDto>
            = productRepositoryService.getByName(name)

    @PutMapping("/{id}")
    fun update(@RequestBody productDto: ProductDto, @PathVariable("id") id : Long) : ProductDto
        = productRepositoryService.update(productDto, id)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable("id") id : Long)
        = productRepositoryService.delete(id)
}