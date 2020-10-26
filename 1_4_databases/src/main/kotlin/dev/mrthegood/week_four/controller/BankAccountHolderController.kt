package dev.mrthegood.week_four.controller

import dev.mrthegood.week_four.models.BankAccountHolder
import dev.mrthegood.week_four.services.BankAccountHolderService
import dev.mrthegood.week_four.util.exception.BankAccountHolderNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import javax.validation.Valid

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
    fun createBankAccountHolder(@Valid @RequestBody accountHolder: BankAccountHolder): ResponseEntity<Long> {
        val id = service.createBankAccountHolder(accountHolder)
        return ResponseEntity.created(URI("/$id")).apply { body(id) }.build()
    }


    @PutMapping("")
    fun updateBankAccountHolder(@Valid @RequestBody accountHolder: BankAccountHolder) {
        service.updateBankAccountHolder(accountHolder)
    }


    @DeleteMapping("/{id}")
    fun deleteBankAccountHolder(@PathVariable id: Long) {
        val accountHolder = service.getBankAccountHolder(id) ?: throw BankAccountHolderNotFoundException("Non-existing account holder `$id` cannot be deleted.")
        service.deleteBankAccountHolder(accountHolder)
    }
}