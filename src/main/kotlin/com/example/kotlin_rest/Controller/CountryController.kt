package com.example.kotlin_rest.Controller


import com.example.kotlin_rest.Dto.CountryDto
import com.example.kotlin_rest.Service.CountryService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/countries")
class CountryController(

    private val countryService: CountryService,

    ){
    @GetMapping
    fun getAll(@RequestParam("page") pageIndex: Int): List<CountryDto> =

        countryService.getAll(pageIndex)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): CountryDto =
        countryService.findById(id)

    @GetMapping("/name")
    fun searchCountries(@RequestParam("name") searchText:  String):
            CountryDto =
        countryService.searchCountries(searchText)

    @DeleteMapping("/{id}")
    fun deleteCountryById(@PathVariable id: Int) =
        countryService.deleteById(id)

    @PostMapping
    fun addCountry(@RequestBody country: CountryDto) =
        countryService.createCountry(country)

}