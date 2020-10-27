package dev.mrthegood.layers.util.extensions

import java.util.*

/**
 * Created by maartendegoede on 27/10/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */

private val random by lazy { Random() }

fun generateAccountNumber() =
    String.format("%08d", random.nextInt(99999999))