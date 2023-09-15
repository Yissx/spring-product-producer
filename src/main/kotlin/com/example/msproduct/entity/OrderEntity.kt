package com.example.msproduct.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "orders")
data class OrderEntity(
    @Id
    var id : UUID = UUID.randomUUID(),

    @NotNull
    @Column(name="order_date")
    var orderDate : LocalDateTime? = null,

    @ManyToOne
    @JoinColumn(name = "client_id")
    var client : ClientEntity? = null,

    @OneToMany//(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name ="order_id")
    var orderProducts : List<OrderProductEntity>? = null
)