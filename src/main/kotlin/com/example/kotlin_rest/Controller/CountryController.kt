package com.example.kotlin_rest.Controller

import com.example.kotlin_rest.Dto.CountyDto
import com.example.kotlin_rest.Service.CountryService
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/countries")
class CountryController (

    private val countryService: CountryService,

){
    @GetMapping
    fun getAll(@RequestParam("page") pageIndex: Int): List<CountyDto> =

        countryService.getAll(pageIndex)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): CountyDto =
        countryService.findById(id)

    @GetMapping("/name")
    fun searchCountries(@RequestParam("name") searchText:  String):
            CountyDto =
        countryService.searchCountries(searchText)
}