package dev.mrthegood.week_two

import dev.mrthegood.week_two.service.StringService
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.springframework.boot.test.context.SpringBootTest

/**
 * Created by maartendegoede on 24/09/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
@SpringBootTest
class StringRepositoryTests {
    @Mock
    lateinit var stringServiceMock: StringService

    @InjectMocks
    lateinit var stringRepository: StringRepository


    @Test
    fun `ensure storage is empty`() {
        assert(stringRepository.counted.isEmpty())
    }

    @Test
    fun `ensure storage is updated`() {
        // Given
        val input = "Test Word Count"
        `when`(stringServiceMock.count(input)).then { 3 }

        // When
        stringRepository.count(input)

        // Then
        assert(stringRepository.counted.containsKey(input))
        assert(stringRepository.counted[input] == 3)
    }

    @Test
    fun `ensure StringService is called`() {
        // Given
        val input = "Call Function Test"
        `when`(stringServiceMock.count(input)).then { 3 }

        // When
        stringRepository.count(input)

        // Then
        verify(stringServiceMock).count(input)
    }
}