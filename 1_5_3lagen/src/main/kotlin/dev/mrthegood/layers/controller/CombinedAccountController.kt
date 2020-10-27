package dev.mrthegood.layers.controller

import dev.mrthegood.layers.models.CombinedAccount
import dev.mrthegood.layers.services.CombinedAccountService
import dev.mrthegood.layers.util.exception.CombinedAccountNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import javax.validation.Valid


@RestController
@RequestMapping("CombinationAccount")
class CombinedAccountController(
    private val combinationAccountService: CombinedAccountService,
) {

    @GetMapping("")
    fun getAccounts() = combinationAccountService.combinedAccounts


    @GetMapping("/{id}")
    fun getBankAccount(@PathVariable id: Long): CombinedAccount {
        return combinationAccountService.getCombinedAccount(id) ?: throw CombinedAccountNotFoundException("Account `$id` not found")
    }


    @PostMapping("")
    fun createAccount(@Valid @RequestBody account: CombinedAccount): ResponseEntity<Long> {
        val id = combinationAccountService.createCombinedAccount(account)
        return ResponseEntity.created(URI("/$id")).apply { body(id) }.build()
    }


    @PutMapping("")
    fun updateAccount(@Valid @RequestBody account: CombinedAccount) {
        combinationAccountService.updateCombinedAccount(account)
    }


    @DeleteMapping("/{id}")
    fun deleteBankAccount(@PathVariable id: Long) {
        combinationAccountService.deleteCombinedAccount(id)
    }
}