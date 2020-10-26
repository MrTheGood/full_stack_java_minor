package dev.mrthegood.layers.controller

import dev.mrthegood.layers.models.BankAccount
import dev.mrthegood.layers.services.BankAccountService
import dev.mrthegood.layers.util.exception.BankAccountNotFoundException
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