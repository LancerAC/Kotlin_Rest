package com.example.kotlin_rest.Repository


import com.example.kotlin_rest.Dto.CountryDto
import com.example.kotlin_rest.Entity.CountryEntity
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CountryRepository : CrudRepository<CountryEntity, Int>{

    fun findByOrderByName(pageable: PageRequest): List<CountryEntity>

    fun findByName(name: String): CountryDto
}