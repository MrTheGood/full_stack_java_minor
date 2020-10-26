package dev.mrthegood.week_four.repository

import dev.mrthegood.week_four.models.BankAccountHolder
import org.springframework.stereotype.Repository
import kotlin.collections.set

/**
 * Created by maartendegoede on 05/10/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
@Repository
class BankAccountHolderRepository {
    private val accountHolders = mutableMapOf<Long, BankAccountHolder>()

    fun save(accountHolder: BankAccountHolder) =
        //fixme: if the id already exists, the accountHolder will not be created.
        // there's a small chance that duplicate id's will be generated.
        // For now we're just assuming that all id's are unique.
        accountHolders.putIfAbsent(accountHolder.id, accountHolder)

    fun find(primaryKey: Long) = accountHolders[primaryKey]

    fun findAll() = accountHolders.map { it.value }

    fun count() = accountHolders.size

    fun update(accountHolder: BankAccountHolder) {
        accountHolders[accountHolder.id] = accountHolder
    }

    fun delete(accountHolder: BankAccountHolder) { delete(accountHolder.id) }
    fun delete(id: Long) { accountHolders.remove(id) }
    // todo: bankAccounts.remove(id) ?: throw BankAccountNotFoundException("Cannot delete non-existing account: `$id`")

    fun exists(id: Long) = accountHolders.containsKey(id)
}