package com.example.msproduct.entity

import jakarta.persistence.CascadeType
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
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.util.UUID

@Entity
@Table(name = "product")
class ProductEntity (
    @Id
    var id: UUID = UUID.randomUUID(),

    @NotNull
    @NotEmpty(message = "name must not be empty")
    var name: String? = null,

    @NotNull
    @Min(value = 0, message = "price can not be negative")
    var price: Double? = null,

    @NotNull
    var description: String? = null,

    @OneToMany//(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name ="product_id")
    var orderProducts : List<OrderProductEntity>? = null
)