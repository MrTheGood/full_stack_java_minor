package dev.mrthegood.week_three.models

import dev.mrthegood.week_three.util.extensions.randomLong
import java.util.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


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