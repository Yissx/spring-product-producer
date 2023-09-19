package com.example.msproduct.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.util.UUID

@Entity
@Table(name = "clients")
data class ClientEntity (
    @Id
    var id : UUID = UUID.randomUUID(),

    @NotNull
    @NotBlank
    var name : String? = null,

    @NotNull
    var lastname : String? = null,

    @NotNull
    @Size(min = 10, max = 10)
    var cellphone : String? = null,

    @NotNull
    @NotBlank
    var address : String? = null,

    @OneToMany(mappedBy = "client",
               orphanRemoval = true,
               cascade = [CascadeType.ALL],
               fetch = FetchType.LAZY)
    var orders : List<OrderEntity>? = null
)