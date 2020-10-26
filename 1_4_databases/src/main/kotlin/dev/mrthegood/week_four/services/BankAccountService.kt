package dev.mrthegood.week_four.services

import dev.mrthegood.week_four.models.BankAccount
import dev.mrthegood.week_four.repository.BankAccountRepository
import org.springframework.stereotype.Service


/**
 * Created by maartendegoede on 05/10/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
@Service
class BankAccountService(
    private val repository: BankAccountRepository
) {
    val bankAccounts: List<Any> get() = repository.findAll().toList()

    fun getBankAccount(id: Long): BankAccount? = repository.findById(id).orElse(null)

    fun createAccount(bankAccount: BankAccount) = repository.save(bankAccount).id()

    fun updateAccount(bankAccount: BankAccount) {
        repository.save(bankAccount)
    }

    fun blockAccount(bankAccount: BankAccount) {
        bankAccount.isBlocked = true
        repository.save(bankAccount)
    }

    fun deleteAccount(account: BankAccount) = repository.delete(account)
    fun deleteAccount(id: Long) = repository.deleteById(id)
}