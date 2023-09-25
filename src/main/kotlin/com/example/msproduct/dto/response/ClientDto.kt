package com.example.msproduct.dto.response

import jakarta.validation.constraints.NotNull
import java.util.UUID

data class ClientDto (
    var id : UUID? = null,

    @NotNull
    var name : String? = null,

    @NotNull
    var lastname : String? = null,

    @NotNull
    var cellphone : String? = null,

    @NotNull
    var address : String? = null,
)