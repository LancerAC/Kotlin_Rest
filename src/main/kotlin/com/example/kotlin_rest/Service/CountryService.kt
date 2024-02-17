package com.example.kotlin_rest.Service

import com.example.kotlin_rest.Dto.CountyDto
import org.springframework.stereotype.Service

@Service
interface CountryService {

    fun getAll(pageIndex: Int): List<CountyDto>

    fun findById(id: Int): CountyDto

    fun searchCountries(name: String): CountyDto
}