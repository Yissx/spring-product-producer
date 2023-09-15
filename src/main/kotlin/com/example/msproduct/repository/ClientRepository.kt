package com.example.msproduct.repository

import com.example.msproduct.entity.ClientEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ClientRepository : JpaRepository<ClientEntity, UUID> {
}