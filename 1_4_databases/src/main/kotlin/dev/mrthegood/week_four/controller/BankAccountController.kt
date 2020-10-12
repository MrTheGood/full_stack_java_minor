package dev.mrthegood.week_four.controller

import dev.mrthegood.week_four.models.BankAccount
import dev.mrthegood.week_four.services.BankAccountService
import dev.mrthegood.week_four.util.exception.BankAccountNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import javax.validation.Valid


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
    fun createAccount(@Valid @RequestBody account: BankAccount): ResponseEntity<Long> {
        val id = bankAccountService.createAccount(account)
        return ResponseEntity.created(URI("/$id")).apply { body(id) }.build()
    }


    @PutMapping("")
    fun updateAccount(@Valid @RequestBody account: BankAccount) {
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