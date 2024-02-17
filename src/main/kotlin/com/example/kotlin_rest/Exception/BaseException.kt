package com.example.kotlin_rest.Exception

import org.springframework.http.HttpStatus

abstract class BaseException(
    val apiError: ApiError,
    val httpStatus: HttpStatus,
): RuntimeException(apiError.description) {

}