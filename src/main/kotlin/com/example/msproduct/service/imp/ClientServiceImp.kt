package com.example.msproduct.service.imp

import com.example.msproduct.dto.ClientDto
import com.example.msproduct.errors.EntityNotFoundException
import com.example.msproduct.mapper.ClientMapper
import com.example.msproduct.repository.ClientRepository
import com.example.msproduct.service.ClientService
import org.springframework.stereotype.Service

@Service
class ClientServiceImp (
    private val clientRepository: ClientRepository,
    private val clientMapper: ClientMapper
    ) : ClientService {

    override fun create(clientDto: ClientDto): ClientDto {
        val entity = clientMapper.toEntity(clientDto)
        val response = clientRepository.save(entity)
        return clientMapper.toDto(response)
    }

    override fun findAll(): List<ClientDto> {
        val response = clientRepository.findAll()
        return clientMapper.toDto(response)
    }

    override fun findById(id: Long): ClientDto {
        val response = clientRepository.findById(id).orElseThrow{
            EntityNotFoundException("Non-existent client entity with id $id")
        }
        return clientMapper.toDto(response)
    }

    override fun update(clientDto: ClientDto, id: Long): ClientDto {
        val entity = clientRepository.findById(id).orElseThrow{
            EntityNotFoundException("Non-existent client entity with id $id")
        }
        clientMapper.updateEntity(clientDto, entity)
        val response = clientRepository.save(entity)
        return clientMapper.toDto(response)
    }

    override fun delete(id: Long) {
        clientRepository.deleteById(id)
    }
}