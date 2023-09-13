package com.example.msproduct.service

import com.example.msproduct.dto.ClientDto

interface ClientService {
    fun create(clientDto: ClientDto) : ClientDto

    fun findAll() : List<ClientDto>

    fun findById(id : Long) : ClientDto

    fun update(clientDto: ClientDto, id : Long) : ClientDto

    fun delete(id : Long)
}