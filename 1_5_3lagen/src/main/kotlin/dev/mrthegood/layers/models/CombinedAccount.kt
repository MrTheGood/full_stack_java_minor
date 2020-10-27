package dev.mrthegood.layers.models

import javax.persistence.*


/**
 * Created by maartendegoede on 27/10/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
@Entity
@Table(name = "combinedAccounts")
class CombinedAccount : BaseEntity() {
    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    @JoinColumn(name = "accountOneId")
    lateinit var bankAccountOne: BankAccount

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    @JoinColumn(name = "accountTwoId")
    lateinit var bankAccountTwo: BankAccount
}