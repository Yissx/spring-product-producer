package com.example.msproduct.errors

import org.springframework.http.HttpStatus

data class ErrorCustomized (
    var code: HttpStatus = HttpStatus.BAD_REQUEST,
    var message : String? = null
)