package dev.mrthegood.week_four.models

import javax.persistence.*


/**
 * Created by maartendegoede on 05/10/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
@Entity
@Table(name = "bankAccounts")
class BankAccount : BaseEntity() {
    lateinit var iBAN: String


    @ManyToMany(
        fetch = FetchType.LAZY,
        cascade = [
            CascadeType.PERSIST,
            CascadeType.MERGE,
        ],
    )
    @JoinTable(
        name = "bankAccount_accountholders",
        joinColumns = [JoinColumn(name = "accountId")],
        inverseJoinColumns = [JoinColumn(name = "holderId")]
    )
    lateinit var accountHolders: MutableList<BankAccountHolder>

    var saldo: Long? = null
    var isBlocked: Boolean = false
}