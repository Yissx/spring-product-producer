package com.example.msproduct.service

import com.example.msproduct.dto.ClientDto
import java.util.UUID

interface ClientService {
    fun create(clientDto: ClientDto) : ClientDto

    fun findAll() : List<ClientDto>

    fun findById(id : UUID) : ClientDto

    fun update(clientDto: ClientDto, id : UUID) : ClientDto

    fun delete(id : UUID)
}