package dev.mrthegood.layers.repository

import dev.mrthegood.layers.aspect.PerformanceLogging
import dev.mrthegood.layers.models.BankAccount
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by maartendegoede on 05/10/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
@PerformanceLogging
@Repository
interface BankAccountRepository : JpaRepository<BankAccount, Long>