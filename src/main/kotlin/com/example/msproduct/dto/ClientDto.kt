package com.example.msproduct.dto

import java.util.UUID

data class ClientDto (
    var id : UUID? = null,

    var name : String? = null,

    var lastname : String? = null,

    var cellphone : String? = null,

    var adress : String? = null,
)