package com.example.msproduct.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.UUID

@Entity
@Table(name = "order_product")
class OrderProductEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null,

    @OneToMany
    @JoinColumn(name = "product_id", nullable = false)
    var products : List<ProductEntity>? = null,

    @OneToMany
    @JoinColumn(name = "order_id", nullable = false)
    var orders : List<OrderEntity>? = null
)