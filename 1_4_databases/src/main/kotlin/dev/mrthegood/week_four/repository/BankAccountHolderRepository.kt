package dev.mrthegood.week_four.repository

import dev.mrthegood.week_four.models.BankAccountHolder
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * Created by maartendegoede on 05/10/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
@Repository
interface BankAccountHolderRepository : CrudRepository<BankAccountHolder, Long>