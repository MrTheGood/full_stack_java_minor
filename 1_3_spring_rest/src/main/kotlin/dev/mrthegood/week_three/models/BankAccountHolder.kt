package dev.mrthegood.week_three.models

import dev.mrthegood.week_three.util.extensions.randomLong

/**
 * Created by maartendegoede on 05/10/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
data class BankAccountHolder(
    val firstname: String,
    val lastname: String,
) {
    val id: Long = randomLong()
}