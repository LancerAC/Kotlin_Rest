package com.example.kotlin_rest.Service

import CountryDto
import org.springframework.stereotype.Service

@Service
interface CountryService {

    fun getAll(pageIndex: Int): List<CountryDto>

    fun findById(id: Int): CountryDto

    fun searchCountries(name: String): CountryDto

    fun deleteById(id: Int)

    fun createCountry(country: CountryDto)
}