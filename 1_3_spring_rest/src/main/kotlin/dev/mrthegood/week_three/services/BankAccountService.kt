package dev.mrthegood.week_three.services

import dev.mrthegood.week_three.models.BankAccount
import dev.mrthegood.week_three.repository.BankAccountRepository
import org.springframework.stereotype.Service
import java.lang.IllegalStateException
import java.util.*
import java.util.function.Consumer


/**
 * Created by maartendegoede on 05/10/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
@Service
class BankAccountService(
    private val repository: BankAccountRepository
) {
    val bankAccounts: List<Any> get() = repository.findAll()

    fun getBankAccount(id: Long) = repository.find(id)

    fun createAccount(bankAccount: BankAccount) = repository.save(bankAccount)?.id
        ?: throw IllegalStateException("Duplicate IDs generated")

    fun updateAccount(bankAccount: BankAccount) {
        repository.update(bankAccount)
    }

    fun blockAccount(bankAccount: BankAccount) {
        bankAccount.isBlocked = true
        repository.update(bankAccount)
    }

    fun deleteAccount(account: BankAccount) = repository.delete(account)
    fun deleteAccount(id: Long) = repository.delete(id)
}