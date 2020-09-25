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
@ContextConfiguration(classes = [DefaultStringService::class])
class DefaultStringServiceTests {
    @InjectMocks
    lateinit var defaultStringService: DefaultStringService


    @Test
    fun `ensure DefaultStringService_reverse strings are reversed`() {
        // Given
        // When
        val result = defaultStringService.reverse("Test")

        // Then
        assert(result == "tseT")
    }


    @Test
    fun `ensure DefaultStringService_count words are counted`() {
        // Given
        // When
        val result = defaultStringService.count("Test Word Count Correct")

        // Then
        assert(result == 4)
    }
}