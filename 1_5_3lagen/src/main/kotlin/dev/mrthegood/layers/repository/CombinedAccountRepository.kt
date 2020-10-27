package dev.mrthegood.layers.repository

import dev.mrthegood.layers.models.CombinedAccount
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by maartendegoede on 27/10/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
@Repository
interface CombinedAccountRepository : JpaRepository<CombinedAccount, Long>