package com.example.msproduct.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import java.util.UUID

@Entity
@Table(name = "stock")
class StockEntity (
    @Id
    var id : UUID = UUID.randomUUID(),

    @NotNull
    @OneToOne
    @JoinColumn(name = "product_id")
    var product : ProductEntity? = null,

    @NotNull
    var stock : Int = 0
)