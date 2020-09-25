package dev.mrthegood.week_two.service

/**
 * Created by maartendegoede on 22/09/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
abstract class StringService {
    abstract fun reverse(string: String): String
    open fun count(string: String) = string.count { it == ' ' } + 1
}