package dev.mrthegood.week_four.models

import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

/**
 * Created by maartendegoede on 05/10/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
@Entity
@Table(name = "bankAccountHolders")
class BankAccountHolder : BaseEntity() {
    enum class Gender {
        Nonbinary, Agender, Genderqueer, Bigender, Genderfluid, Other
    }

    @NotBlank(message = "firstname cannot be blank")
    lateinit var firstname: String
    @NotBlank(message = "lastname cannot be blank")
    lateinit var lastname: String

    @NotBlank(message = "gender is not optional")
    @Enumerated(EnumType.STRING)
    lateinit var gender: Gender

    @Embedded
    lateinit var address: Address

    @NotEmpty(message = "At least one bankAccount")
    @ManyToMany(
        fetch = FetchType.LAZY,
        cascade = [
            CascadeType.PERSIST,
            CascadeType.MERGE,
        ],
        mappedBy = "accountHolders"
    )
    lateinit var accounts: MutableList<BankAccount>
}