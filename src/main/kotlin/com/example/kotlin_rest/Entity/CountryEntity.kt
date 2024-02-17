package com.example.kotlin_rest.Entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor


@Entity
@Table(name = "country")
data class CountryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val name: String = "",
    val population: Int = 0
) {
    data class Builder(
        var id: Int = 0,
        var name: String = "",
        var population: Int = 0
    ) {
        fun id(id: Int) = apply { this.id = id }
        fun name(name: String) = apply { this.name = name }
        fun population(population: Int) = apply { this.population = population }

        fun build() = CountryEntity(id, name, population)
    }
}


