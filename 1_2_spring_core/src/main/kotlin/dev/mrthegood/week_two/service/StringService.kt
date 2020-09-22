package dev.mrthegood.week_two.service

/**
 * Created by maartendegoede on 22/09/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
interface StringService {
    fun reverse(string: String): String
    fun count(string: String): Int
}