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
        `when`(stringServiceMock.count("Test")).then { 4 }

        // When
        stringRepository.count("Test")

        // Then
        assert(stringRepository.counted.containsKey("Test"))
        assert(stringRepository.counted["Test"] == 4)
    }

    @Test
    fun `ensure StringService is called`() {
        // Given
        `when`(stringServiceMock.count("Call")).then { 4 }

        // When
        stringRepository.count("Call")

        // Then
        verify(stringServiceMock).count("Call")
    }
}