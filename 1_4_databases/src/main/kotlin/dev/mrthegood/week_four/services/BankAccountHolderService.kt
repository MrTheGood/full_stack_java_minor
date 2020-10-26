package dev.mrthegood.week_four.services

import dev.mrthegood.week_four.models.BankAccountHolder
import dev.mrthegood.week_four.repository.BankAccountHolderRepository
import dev.mrthegood.week_four.repository.BankAccountRepository
import org.springframework.stereotype.Service
import java.lang.IllegalStateException


/**
 * Created by maartendegoede on 05/10/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
@Service
class BankAccountHolderService(
    private val repository: BankAccountHolderRepository,
    private val bankAccountRepository: BankAccountRepository,
) {
    val bankAccountHolders: List<Any> get() = repository.findAll()

    fun getBankAccountHolder(id: Long) = repository.find(id)

    fun getBankAccounts(holderId: Long) = bankAccountRepository.findAll().filter { it.accountHolders.any { it.id == holderId } }

    fun createBankAccountHolder(accountHolder: BankAccountHolder) = repository.save(accountHolder)?.id
        ?: throw IllegalStateException("Duplicate IDs generated")

    fun updateBankAccountHolder(holder: BankAccountHolder) {
        repository.update(holder)
    }

    fun deleteBankAccountHolder(holder: BankAccountHolder) = repository.delete(holder)
    fun deleteBankAccountHolder(id: Long) = repository.delete(id)
}