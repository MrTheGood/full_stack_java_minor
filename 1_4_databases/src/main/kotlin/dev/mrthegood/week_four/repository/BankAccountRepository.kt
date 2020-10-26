package dev.mrthegood.week_four.repository

import dev.mrthegood.week_four.models.BankAccount
import org.springframework.stereotype.Repository
import kotlin.collections.set

/**
 * Created by maartendegoede on 05/10/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
@Repository
class BankAccountRepository {
    private val bankAccounts = mutableMapOf<Long, BankAccount>()

    fun save(bankAccount: BankAccount) =
        //fixme: if the id already exists, the accountHolder will not be created.
        // there's a small chance that duplicate id's will be generated.
        // For now we're just assuming that all id's are unique.
        bankAccounts.putIfAbsent(bankAccount.id, bankAccount)

    fun find(primaryKey: Long) = bankAccounts[primaryKey]

    fun findAll() = bankAccounts.map { it.value }

    fun count() = bankAccounts.size

    fun update(bankAccount: BankAccount) {
        bankAccounts[bankAccount.id] = bankAccount
    }

    fun delete(bankAccount: BankAccount) { delete(bankAccount.id) }
    fun delete(id: Long) { bankAccounts.remove(id) }
        // todo: bankAccounts.remove(id) ?: throw BankAccountNotFoundException("Cannot delete non-existing account: `$id`")

    fun exists(id: Long) = bankAccounts.containsKey(id)
}