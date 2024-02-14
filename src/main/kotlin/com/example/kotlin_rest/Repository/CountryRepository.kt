package com.example.kotlin_rest.Repository

import com.example.kotlin_rest.Dto.CountyDto
import com.example.kotlin_rest.Entity.CountryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CountryRepository : CrudRepository<CountryEntity, Int>{
}