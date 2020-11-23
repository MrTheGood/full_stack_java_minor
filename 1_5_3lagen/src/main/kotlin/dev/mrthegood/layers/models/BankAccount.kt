package dev.mrthegood.layers.models

import org.hibernate.validator.constraints.Length
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotBlank


/**
 * Created by maartendegoede on 05/10/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
@Entity
@Table(name = "bankAccounts")
class BankAccount : BaseEntity() {
    @NotBlank(message = "iBAN cannot be blank")
    lateinit var iBAN: String

    @Length(min = 8, max = 8)
    // todo: should never be visible to the user
    @NotBlank(message = "accountNumber cannot be blank")
    lateinit var accountNumber: String


    var saldo: Long? = null
    var isBlocked: Boolean = false
}