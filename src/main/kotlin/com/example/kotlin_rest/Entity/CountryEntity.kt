package com.example.kotlin_rest.Entity

import com.example.kotlin_rest.Dto.CityDto
import jakarta.persistence.*
import lombok.AllArgsConstructor


@Entity
@AllArgsConstructor
@Table(name = "country")
data class CountryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val name: String = "",
    val population: Int = 0,

    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    val cityList: List<CityEntity> = emptyList()
) {
    data class Builder(
        var id: Int = 0,
        var name: String = "",
        var population: Int = 0,
        var cityList: List<CityEntity> = emptyList()
    ) {

        fun id(id: Int) = apply { this.id = id }
        fun name(name: String) = apply { this.name = name }
        fun population(population: Int) = apply { this.population = population }
        fun cityList(cityList: List<CityEntity>) = apply { this.cityList = cityList }

        fun build() = CountryEntity(id, name, population, cityList)
    }



}


