package com.example.msproduct.controller

import com.example.msproduct.dto.ClientDto
import com.example.msproduct.service.imp.ClientServiceImp
import org.springframework.http.HttpStatus
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
@RequestMapping("/client")
class ClientController (val clientServiceImp: ClientServiceImp){

    @GetMapping
    fun findAll() : List<ClientDto>
        = clientServiceImp.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id : Long) : ClientDto
        = clientServiceImp.findById(id)

    @PostMapping
    fun create(@RequestBody clientDto: ClientDto) : ClientDto
        = clientServiceImp.create(clientDto)

    @PutMapping("/{id}")
    fun update(@RequestBody clientDto: ClientDto, @PathVariable("id") id: Long) : ClientDto
        = clientServiceImp.update(clientDto, id)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable("id") id: Long)
        = clientServiceImp.delete(id)
}