package com.example.msproduct.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.UUID
import java.util.Date

@Entity
@Table(name = "orders")
data class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null,

    @NotNull
    @Column(name="order_date")
    var orderDate : Date? = null,

    @ManyToOne
    @JoinColumn(name = "client_id")
    var client : ClientEntity? = null,

    @ManyToOne
    var orderProduct : OrderProductEntity? = null
)