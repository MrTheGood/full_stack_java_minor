package dev.mrthegood.layers.services

import dev.mrthegood.layers.models.CombinedAccount
import dev.mrthegood.layers.repository.BankAccountRepository
import dev.mrthegood.layers.repository.CombinedAccountRepository
import dev.mrthegood.layers.util.exception.CombinedAccountNotFoundException
import dev.mrthegood.layers.util.extensions.generateAccountNumber
import org.springframework.stereotype.Service
import javax.security.auth.login.AccountNotFoundException


/**
 * Created by maartendegoede on 27/10/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
@Service
class CombinedAccountService(
    private val bankAccountRepository: BankAccountRepository,
    private val combinedAccountRepository: CombinedAccountRepository,
) {
    val combinedAccounts: List<Any> get() = combinedAccountRepository.findAll().toList()

    fun getCombinedAccount(id: Long): CombinedAccount? = combinedAccountRepository.findById(id).orElse(null)

    fun createCombinedAccount(combinedAccount: CombinedAccount) =
        combinedAccountRepository.save(combinedAccount.apply {
            bankAccountRepository.save(bankAccountOne.apply { accountNumber = generateAccountNumber() })
            bankAccountRepository.save(bankAccountTwo.apply { accountNumber = generateAccountNumber() })
        }).id()

    fun updateCombinedAccount(combinedAccount: CombinedAccount) {
        combinedAccountRepository.save(combinedAccount)
    }

    fun deleteCombinedAccount(combinedAccount: CombinedAccount) {
        combinedAccountRepository.delete(combinedAccount)
        bankAccountRepository.delete(combinedAccount.bankAccountOne)
        bankAccountRepository.delete(combinedAccount.bankAccountTwo)
    }

    @Throws(AccountNotFoundException::class)
    fun deleteCombinedAccount(id: Long) {
        val combinedAccount = combinedAccountRepository.findById(id).orElse(null) ?: throw CombinedAccountNotFoundException("Account `$id` not found")
        combinedAccountRepository.delete(combinedAccount)
        bankAccountRepository.delete(combinedAccount.bankAccountOne)
        bankAccountRepository.delete(combinedAccount.bankAccountTwo)
    }

}