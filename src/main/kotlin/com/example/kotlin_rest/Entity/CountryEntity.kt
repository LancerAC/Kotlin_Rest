package com.example.kotlin_rest.Entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "country")
class CountryEntity (

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    val id: Int = 0,
    val name: String = "",
    val population: Int = 0
)