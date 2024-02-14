package com.example.kotlin_rest.Service

import com.example.kotlin_rest.Dto.CountyDto
import com.example.kotlin_rest.Entity.CountryEntity
import com.example.kotlin_rest.Repository.CountryRepository
import org.springframework.stereotype.Service

@Service
class CountryServiceImpl(
    private val countryRepository: CountryRepository
) : CountryService
{
    override fun getAll(): List<CountyDto> {
        return countryRepository.findAll().map {
            it.toDto()
        }
    }

    private fun CountryEntity.toDto(): CountyDto =
        CountyDto(
            id = this.id,
            name = this.name,
            population = this.population,
        )

    }
