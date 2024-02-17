package com.example.kotlin_rest.Exception

import org.springframework.http.HttpStatus

class CountryNotFoundExcep(countryId: Int): BaseException(
    ApiError(
        errorCode = "country.not.found",
        description = "Country not found with id = $countryId"
    ),
    HttpStatus.NOT_FOUND
) {
}