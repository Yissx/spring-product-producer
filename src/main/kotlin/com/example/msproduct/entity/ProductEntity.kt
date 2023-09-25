package com.example.msproduct.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.util.UUID

@Entity
@Table(name = "products")
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

    @OneToOne(
        mappedBy = "product",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    var stock : StockEntity? = null
)