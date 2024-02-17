package com.example.kotlin_rest.Entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "city")
class CityEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val name: String = "",

    @ManyToOne
    @JoinColumn(name ="country_id")
    var country: CountryEntity,
    )