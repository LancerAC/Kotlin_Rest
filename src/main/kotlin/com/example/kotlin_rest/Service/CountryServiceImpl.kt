package com.example.kotlin_rest.Service


import com.example.kotlin_rest.Dto.CityDto
import com.example.kotlin_rest.Dto.CountryDto
import com.example.kotlin_rest.Entity.CityEntity
import com.example.kotlin_rest.Entity.CountryEntity
import com.example.kotlin_rest.Exception.CountryNotFoundExcep
import com.example.kotlin_rest.Repository.CountryRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


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
            ?: throw  CountryNotFoundExcep(id)
    }

    override fun searchCountries(name: String): CountryDto {
        return countryRepository.findByName(name)
    }

    override fun deleteById(id: Int) {
        countryRepository.deleteById(id)
    }

    override fun createCountry(country: CountryDto){
        val newCountry = CountryEntity.Builder()
            .id(country.id)
            .name(country.name)
            .population(country.population)
            .build()

        countryRepository.save(newCountry)


    }
    private fun CityEntity.toDto(): CityDto =
        CityDto(
            name = this.name,
            id = this.id
        )

    private fun CountryEntity.toDto(): CountryDto =
        CountryDto(
            id = this.id,
            name = this.name,
            population = this.population,
            cityList = this.cityList.map { it.toDto() }
        )
    }
