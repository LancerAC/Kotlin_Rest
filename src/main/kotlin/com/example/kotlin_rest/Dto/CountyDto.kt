package com.example.kotlin_rest.Dto

import com.example.kotlin_rest.Entity.CityEntity

data class CountryDto(
    val id: Int,
    val name: String,
    val population: Int,
    val cityList: List<CityDto>
)


