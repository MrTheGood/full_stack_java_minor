package dev.mrthegood.layers.controller

import dev.mrthegood.layers.aspect.PerformanceLogging
import dev.mrthegood.layers.models.CombinedAccount
import dev.mrthegood.layers.services.CombinedAccountService
import dev.mrthegood.layers.util.exception.CombinedAccountNotFoundException
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.cache.annotation.Caching
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import javax.validation.Valid


@RestController
@PerformanceLogging
@RequestMapping("CombinationAccount")
class CombinedAccountController(
    private val combinationAccountService: CombinedAccountService,
) {

    @Cacheable("combinedAccounts")
    @GetMapping("")
    fun getAccounts() = combinationAccountService.combinedAccounts


    @Cacheable("combinedAccounts")
    @GetMapping("/{id}")
    fun getBankAccount(@PathVariable id: Long): CombinedAccount {
        return combinationAccountService.getCombinedAccount(id) ?: throw CombinedAccountNotFoundException("Account `$id` not found")
    }


    @Caching(put = [
        CachePut(value = ["combinedAccounts"], key = "#account.id"),
        CachePut(value = ["accounts"], key = "#account.bankAccountOne.id"),
        CachePut(value = ["accounts"], key = "#account.bankAccountTwo.id"),
    ])
    @PostMapping("")
    fun createAccount(@Valid @RequestBody account: CombinedAccount): ResponseEntity<Long> {
        val id = combinationAccountService.createCombinedAccount(account)
        return ResponseEntity.created(URI("/$id")).apply { body(id) }.build()
    }


    @Caching(put = [
        CachePut(value = ["combinedAccounts"], key = "#account.id"),
        CachePut(value = ["accounts"], key = "#account.accountA.id"),
        CachePut(value = ["accounts"], key = "#account.accountB.id"),
    ])
    @PutMapping("")
    fun updateAccount(@Valid @RequestBody account: CombinedAccount) {
        combinationAccountService.updateCombinedAccount(account)
    }


    @Caching(evict = [
        CacheEvict(value = ["combinedAccounts"], allEntries = true),
        CacheEvict(value = ["accounts"], allEntries = true)
    ])
    @DeleteMapping("/{id}")
    fun deleteBankAccount(@PathVariable id: Long) {
        combinationAccountService.deleteCombinedAccount(id)
    }
}