package dev.mrthegood.layers.repository

import dev.mrthegood.layers.models.BankAccount
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * Created by maartendegoede on 05/10/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
@Repository
interface BankAccountRepository : CrudRepository<BankAccount, Long>