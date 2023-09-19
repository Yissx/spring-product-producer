package com.example.msproduct.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
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

    @NotNull
    @ManyToOne
    @JoinColumn(name = "client_id")
    var client : ClientEntity? = null,

    @ManyToMany(
        fetch = FetchType.LAZY
    )
    @JoinTable(
        name = "order_product",
        joinColumns = [JoinColumn(name = "order_id")],
        inverseJoinColumns = [JoinColumn(name = "product_id")]
    )
    var products : List<ProductEntity>? = null
)