package dev.mrthegood.week_three.services

import dev.mrthegood.week_three.models.BankAccountHolder
import dev.mrthegood.week_three.repository.BankAccountHolderRepository
import dev.mrthegood.week_three.repository.BankAccountRepository
import org.springframework.stereotype.Service


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