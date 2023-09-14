package com.example.msproduct.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
@Entity
@Table(name = "client")
data class ClientEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null,

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
    var adress : String? = null,

    @OneToMany(mappedBy = "client",
               orphanRemoval = true,
               cascade = [CascadeType.ALL],
               fetch = FetchType.EAGER)
    var orders : List<OrderEntity>? = null
)