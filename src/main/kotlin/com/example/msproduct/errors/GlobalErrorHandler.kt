package com.example.msproduct.errors

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@Component
@ControllerAdvice
class GlobalErrorHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(EntityNotFoundException::class)
    fun handleEntityNotFoundException(ex : EntityNotFoundException) : ResponseEntity<ErrorCustomized> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body(ErrorCustomized().apply{
                                 code = HttpStatus.NOT_FOUND
                                 message = ex.message
                             })
    }

    @ExceptionHandler(InvalidRequestBody::class)
    fun handleInvalidRequestBody(ex : InvalidRequestBody) : ResponseEntity<ErrorCustomized> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(ErrorCustomized().apply {
                code = HttpStatus.BAD_REQUEST
                message = ex.message
            })
    }

    @ExceptionHandler(ProductNotAvailable::class)
    fun handleProductNotAvailable(ex : InvalidRequestBody) : ResponseEntity<ErrorCustomized> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(ErrorCustomized().apply {
                code = HttpStatus.BAD_REQUEST
                message = ex.message
            })
    }
}