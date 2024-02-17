package com.example.kotlin_rest.Service

import com.example.kotlin_rest.Dto.CountyDto
import com.example.kotlin_rest.Entity.CountryEntity
import com.example.kotlin_rest.Repository.CountryRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class CountryServiceImpl(
    private val countryRepository: CountryRepository
) : CountryService
{
    override fun getAll(pageIndex: Int): List<CountyDto> {
        return countryRepository.findByOrderByName(PageRequest
            .of(pageIndex, 2)).map {
            it.toDto()
        }
    }

    override fun findById(id: Int): CountyDto {
        return  countryRepository.findByIdOrNull(id)
            ?.toDto()
            ?: throw  RuntimeException("Country not found")
    }

    override fun searchCountries(name: String): CountyDto {
        return countryRepository.findByName(name)
    }

    override fun deleteById(id: Int) {
        countryRepository.deleteById(id)
    }


    private fun CountryEntity.toDto(): CountyDto =
        CountyDto(
            id = this.id,
            name = this.name,
            population = this.population,
        )

    }
