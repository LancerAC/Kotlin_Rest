package com.example.kotlin_rest.Service


import CountryDto
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
    override fun getAll(pageIndex: Int): List<CountryDto> {
        return countryRepository.findByOrderByName(PageRequest
            .of(pageIndex, 2)).map {
            it.toDto()
        }
    }

    override fun findById(id: Int): CountryDto {
        return  countryRepository.findByIdOrNull(id)
            ?.toDto()
            ?: throw  RuntimeException("Country not found")
    }

    override fun searchCountries(name: String): CountryDto {
        return countryRepository.findByName(name)
    }

    override fun deleteById(id: Int) {
        countryRepository.deleteById(id)
    }

    override fun createCountry(country: CountryDto){
        val newCountry = CountryEntity.Builder()
            .name(country.name)
            .population(country.population)
            .build()

        countryRepository.save(newCountry)


    }


    private fun CountryEntity.toDto(): CountryDto =
        CountryDto(
            id = this.id,
            name = this.name,
            population = this.population,
        )

    }
