package dev.mrthegood.week_two

import dev.mrthegood.week_two.service.StringService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

/**
 * Created by maartendegoede on 21/09/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
@Repository
class StringRepository {

    @Autowired
    private lateinit var stringService: StringService

    private val counted = mutableMapOf<String, Int>()

    fun count(input: String) =
        counted.getOrPut(input) { stringService.count(input) }
}