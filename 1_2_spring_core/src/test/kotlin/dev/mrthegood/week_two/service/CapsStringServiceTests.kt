package dev.mrthegood.week_two.service

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

/**
 * Created by maartendegoede on 24/09/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [CapsStringService::class])
class CapsStringServiceTests {

    @InjectMocks
    lateinit var capsStringService: CapsStringService


    @Test
    fun `ensure CapsStringService_reverse strings are capsed`() {
        // Given
        // When
        val result = capsStringService.reverse("Test")

        // Then
        assert(result == "TEST")
    }

    @Test
    fun `ensure CapsStringService_count words are counted`() {
        // Given
        // When
        val result = capsStringService.count("Test Word Count Correct")

        // Then
        assert(result == 4)
    }
}