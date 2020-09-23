package dev.mrthegood.week_two

import dev.mrthegood.week_two.service.CapsStringService
import dev.mrthegood.week_two.service.DefaultStringService
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.springframework.boot.test.context.SpringBootTest

/**
 * Created by maartendegoede on 24/09/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
@SpringBootTest
class StringServiceTests {
    @InjectMocks
    lateinit var defaultStringService: DefaultStringService

    @InjectMocks
    lateinit var capsStringService: CapsStringService


    @Test
    fun `ensure DefaultStringService_reverse strings are reversed`() {
        // Given
        // When
        val result = defaultStringService.reverse("Test")

        // Then
        assert(result == "tseT")
    }


    @Test
    fun `ensure CapsStringService_reverse strings are capsed`() {
        // Given
        // When
        val result = capsStringService.reverse("Test")

        // Then
        assert(result == "TEST")
    }

    @Test
    fun `ensure count characters are counted`() {
        // Given
        // When
        val result = defaultStringService.count("Test")

        // Then
        assert(result == 4)
    }
}