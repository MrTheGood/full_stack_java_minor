package dev.mrthegood.week_four.services

import dev.mrthegood.week_four.models.BankAccountHolder
import dev.mrthegood.week_four.repository.BankAccountHolderRepository
import org.springframework.stereotype.Service


/**
 * Created by maartendegoede on 05/10/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
@Service
class BankAccountHolderService(
    private val repository: BankAccountHolderRepository,
) {
    val bankAccountHolders: List<Any> get() = repository.findAll().toList()

    fun getBankAccountHolder(id: Long): BankAccountHolder? = repository.findById(id).orElse(null)

    fun getBankAccounts(holderId: Long) = repository.findById(holderId).orElse(null)?.accounts

    fun createBankAccountHolder(accountHolder: BankAccountHolder) = repository.save(accountHolder).id()

    fun updateBankAccountHolder(holder: BankAccountHolder) {
        repository.save(holder)
    }

    fun deleteBankAccountHolder(holder: BankAccountHolder) = repository.delete(holder)
    fun deleteBankAccountHolder(id: Long) = repository.deleteById(id)
}