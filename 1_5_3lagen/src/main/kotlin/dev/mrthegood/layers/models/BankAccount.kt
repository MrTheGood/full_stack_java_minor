package dev.mrthegood.layers.models

import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty


/**
 * Created by maartendegoede on 05/10/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
@Entity
@Table(name = "bankAccounts")
class BankAccount : BaseEntity() {
    @NotBlank(message = "iBAN cannot be blank")
    lateinit var iBAN: String


    var saldo: Long? = null
    var isBlocked: Boolean = false
}