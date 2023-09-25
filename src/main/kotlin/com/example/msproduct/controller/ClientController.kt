package com.example.msproduct.controller

import com.example.msproduct.dto.response.ClientDto
import com.example.msproduct.service.ClientService
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
import java.util.UUID

@RestController
@RequestMapping("/clients")
class ClientController (val clientService: ClientService){

    @GetMapping
    fun findAll() : List<ClientDto>
        = clientService.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id : UUID) : ClientDto
        = clientService.findById(id)

    @PostMapping
    fun create(@RequestBody clientDto: ClientDto) : ClientDto
        = clientService.create(clientDto)

    @PutMapping("/{id}")
    fun update(@RequestBody clientDto: ClientDto, @PathVariable("id") id: UUID) : ClientDto
        = clientService.update(clientDto, id)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable("id") id: UUID)
        = clientService.delete(id)
}