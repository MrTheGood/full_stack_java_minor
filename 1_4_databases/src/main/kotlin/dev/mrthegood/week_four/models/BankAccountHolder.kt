package dev.mrthegood.week_four.models

import javax.persistence.*

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

    lateinit var firstname: String
    lateinit var lastname: String

    @Enumerated(EnumType.STRING)
    lateinit var gender: Gender

    @Embedded
    lateinit var address: Address

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