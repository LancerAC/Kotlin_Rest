package com.example.kotlin_rest.Service

import com.example.kotlin_rest.Dto.CountyDto
import org.springframework.stereotype.Service

@Service
interface CountryService {

    fun getAll(): List<CountyDto>
}