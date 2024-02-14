package com.example.kotlin_rest.Service

import com.example.kotlin_rest.Dto.CountyDto
import org.springframework.stereotype.Service

@Service
class CountryServiceImpl : CountryService  {
    override fun getAll(): List<CountyDto> {
        return listOf(
            CountyDto(1, "USA",
                345265),
            CountyDto(2, "Russia",
                3523523)
        )
    }
}