package com.example.msproduct.mapper

import com.example.msproduct.dto.ClientDto
import com.example.msproduct.entity.ClientEntity
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget
import org.mapstruct.NullValueCheckStrategy
import org.mapstruct.NullValuePropertyMappingStrategy
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
interface ClientMapper {

    fun toDto(clientEntity: ClientEntity) : ClientDto

    fun toDto(clientEntities: List<ClientEntity>) : List<ClientDto>

    fun toEntity(clientDto: ClientDto) : ClientEntity

    fun updateEntity(clientDto: ClientDto, @MappingTarget clientEntity: ClientEntity, )
}