package com.example.msproduct.controller

import com.example.msproduct.repository.ProductRepository
import com.example.msproduct.dto.ProductDto
import com.example.msproduct.mapper.ProductMapper
import com.example.msproduct.service.ProductService
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
import java.util.UUID

@RestController
@RequestMapping("/products")
class ProductController (val productService: ProductService){
    @PostMapping
    fun create(@RequestBody productDto: ProductDto) : ProductDto
        = productService.create(productDto)

    @GetMapping
    fun findAll() : List<ProductDto>
        = productService.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id : UUID) : ProductDto
        = productService.findById(id)

    @GetMapping("/search/{search}")
    fun search(@PathVariable("search") search : String) : List<ProductDto>
        = productService.search(search)

    @PutMapping("/{id}")
    fun update(@RequestBody productDto: ProductDto, @PathVariable("id") id : UUID) : ProductDto
        = productService.update(productDto, id)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable("id") id : UUID)
        = productService.delete(id)
}