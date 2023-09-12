package com.example.msproduct.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

@Entity
@Table(name = "product")
class ProductEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @NotNull
    @NotEmpty(message = "name must not be empty")
    var name: String? = null,

    @NotNull
    @Min(value = 0, message = "price can not be negative")
    var price: Double? = null,

    @NotNull
    var description: String? = null
)