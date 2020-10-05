package dev.mrthegood.week_three.controller

import dev.mrthegood.week_three.models.BankAccount
import dev.mrthegood.week_three.services.BankAccountService
import dev.mrthegood.week_three.util.exception.BankAccountNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("BankAccount")
class BankAccountController(
    private val bankAccountService: BankAccountService
) {

    @GetMapping("")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    fun getBankAccounts() = bankAccountService.bankAccounts

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    fun getBankAccount(@PathVariable id: Long): BankAccount {
        return bankAccountService.getBankAccount(id) ?: throw BankAccountNotFoundException("Account `$id` not found")
    }

    @PostMapping("")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    fun createAccount(@RequestBody account: BankAccount): Long {
        return bankAccountService.createAccount(account)
    }

    //todo: validatie op input

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    fun updateAccount(@PathVariable id: Long, @RequestBody account: BankAccount) {
        bankAccountService.updateAccount(account)
    }

    @PutMapping("/block/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    fun blockAccount(@PathVariable id: Long) {
        val account = bankAccountService.getBankAccount(id) ?: throw BankAccountNotFoundException("Non-existing account `$id` cannot be blocked.")
        bankAccountService.blockAccount(account)
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    fun deleteBankAccount(@PathVariable id: Long) {
        val account = bankAccountService.getBankAccount(id) ?: throw BankAccountNotFoundException("Non-existing account `$id` cannot be deleted.")
        bankAccountService.deleteAccount(account)
    }
}