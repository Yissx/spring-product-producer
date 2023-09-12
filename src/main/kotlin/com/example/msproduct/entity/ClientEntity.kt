package com.example.msproduct.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class ClientEntity (
    @Id
    @GeneratedValue
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

    @OneToMany
    var orders : List<OrderEntity>? = null
)