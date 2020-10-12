package dev.mrthegood.week_three.controller

import dev.mrthegood.week_three.models.BankAccount
import dev.mrthegood.week_three.services.BankAccountService
import dev.mrthegood.week_three.util.exception.BankAccountNotFoundException
import dev.mrthegood.week_three.util.exception.IllegalBankAccountException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI


@RestController
@RequestMapping("BankAccount")
class BankAccountController(
    private val bankAccountService: BankAccountService
) {

    @GetMapping("")
    fun getBankAccounts() = bankAccountService.bankAccounts


    @GetMapping("/{id}")
    fun getBankAccount(@PathVariable id: Long): BankAccount {
        return bankAccountService.getBankAccount(id) ?: throw BankAccountNotFoundException("Account `$id` not found")
    }


    @PostMapping("")
    fun createAccount(@RequestBody account: BankAccount): ResponseEntity<Long> {
        if (account.iBAN.isBlank())
            throw IllegalBankAccountException("Account holder `${account.id}` cannot be created. IBAN cannot be blank")
        if (account.accountHolders.isEmpty())
            throw IllegalBankAccountException("Account holder `${account.id}` cannot be created. Requires at least 1 account holder")

        val id = bankAccountService.createAccount(account)
        return ResponseEntity.created(URI("/$id")).apply { body(id) }.build()
    }


    @PutMapping("")
    fun updateAccount(@RequestBody account: BankAccount) {
        if (account.iBAN.isBlank())
            throw IllegalBankAccountException("Account holder `${account.id}` cannot be updated. IBAN cannot be blank")
        if (account.accountHolders.isEmpty())
            throw IllegalBankAccountException("Account holder `${account.id}` cannot be updated. Requires at least 1 account holder")

        bankAccountService.updateAccount(account)
    }


    @PutMapping("/block/{id}")
    fun blockAccount(@PathVariable id: Long) {
        val account = bankAccountService.getBankAccount(id) ?: throw BankAccountNotFoundException("Non-existing account `$id` cannot be blocked.")
        bankAccountService.blockAccount(account)
    }


    @DeleteMapping("/{id}")
    fun deleteBankAccount(@PathVariable id: Long) {
        val account = bankAccountService.getBankAccount(id) ?: throw BankAccountNotFoundException("Non-existing account `$id` cannot be deleted.")
        bankAccountService.deleteAccount(account)
    }
}