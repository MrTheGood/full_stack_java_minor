package dev.mrthegood.week_three.controller

import dev.mrthegood.week_three.models.BankAccount
import dev.mrthegood.week_three.models.BankAccountHolder
import dev.mrthegood.week_three.services.BankAccountHolderService
import dev.mrthegood.week_three.util.exception.BankAccountHolderNotFoundException
import dev.mrthegood.week_three.util.exception.BankAccountNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("BankAccountHolder")
class BankAccountHolderController(
    private val service: BankAccountHolderService
) {

    @GetMapping("")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    fun getBankAccountHolders() = service.bankAccountHolders

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    fun getBankAccountHolder(@PathVariable id: Long): BankAccountHolder {
        return service.getBankAccountHolder(id) ?: throw BankAccountHolderNotFoundException("Account Holder `$id` not found")
    }

    @GetMapping("/{holderId}/accounts")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    fun getBankBankAccounts(@PathVariable holderId: Long): List<BankAccount> {
        return service.getBankAccounts(holderId)
    }

    @PostMapping("")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    fun createBankAccountHolder(@RequestBody accountHolder: BankAccountHolder): Long {
        return service.createBankAccountHolder(accountHolder)
    }

    //todo: validatie op input

    @PutMapping("")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    fun updateBankAccountHolder(@RequestBody accountHolder: BankAccountHolder) {
        service.updateBankAccountHolder(accountHolder)
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    fun deleteBankAccountHolder(@PathVariable id: Long) {
        val accountHolder = service.getBankAccountHolder(id) ?: throw BankAccountHolderNotFoundException("Non-existing account holder `$id` cannot be deleted.")
        service.deleteBankAccountHolder(accountHolder)
    }
}