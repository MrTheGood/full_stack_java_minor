package dev.mrthegood.week_four.models

import dev.mrthegood.week_four.util.extensions.randomLong


/**
 * Created by maartendegoede on 05/10/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
data class BankAccount(
    val iBAN: String,
    var saldo: Long? = null,
    val accountHolders: List<BankAccountHolder>,
    var isBlocked: Boolean = false,
) {
    val id: Long = randomLong()
}