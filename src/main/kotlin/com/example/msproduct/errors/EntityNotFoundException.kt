package com.example.msproduct.errors

import org.springframework.web.bind.annotation.ControllerAdvice


class EntityNotFoundException(override val message: String?) : RuntimeException(){

}
