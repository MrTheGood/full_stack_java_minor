package dev.mrthegood.week_three.controller

import dev.mrthegood.week_three.models.BankAccountHolder
import dev.mrthegood.week_three.services.BankAccountHolderService
import dev.mrthegood.week_three.util.exception.BankAccountHolderNotFoundException
import dev.mrthegood.week_three.util.exception.IllegalBankAccountHolderException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("BankAccountHolder")
class BankAccountHolderController(
    private val service: BankAccountHolderService
) {

    @GetMapping("")
    fun getBankAccountHolders() = service.bankAccountHolders


    @GetMapping("/{id}")
    fun getBankAccountHolder(@PathVariable id: Long): BankAccountHolder {
        return service.getBankAccountHolder(id) ?: throw BankAccountHolderNotFoundException("Account Holder `$id` not found")
    }


    @GetMapping("/{holderId}/accounts")
    fun getBankBankAccounts(@PathVariable holderId: Long) = service.getBankAccounts(holderId)


    @PostMapping("")
    fun createBankAccountHolder(@RequestBody accountHolder: BankAccountHolder): ResponseEntity<Long> {
        if (accountHolder.firstname.isBlank() || accountHolder.lastname.isBlank())
            throw IllegalBankAccountHolderException("Account holder `${accountHolder.id}` cannot be created. Name cannot be blank")

        val id = service.createBankAccountHolder(accountHolder)
        return ResponseEntity.created(URI("/$id")).apply { body(id) }.build()
    }


    @PutMapping("")
    fun updateBankAccountHolder(@RequestBody accountHolder: BankAccountHolder) {
        if (accountHolder.firstname.isBlank() || accountHolder.lastname.isBlank())
            throw IllegalBankAccountHolderException("Account holder `${accountHolder.id}` cannot be updated. Name cannot be blank")
        service.updateBankAccountHolder(accountHolder)
    }


    @DeleteMapping("/{id}")
    fun deleteBankAccountHolder(@PathVariable id: Long) {
        val accountHolder = service.getBankAccountHolder(id) ?: throw BankAccountHolderNotFoundException("Non-existing account holder `$id` cannot be deleted.")
        service.deleteBankAccountHolder(accountHolder)
    }
}