package dev.mrthegood.week_two.service

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

/**
 * Created by maartendegoede on 22/09/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
@Service
@Profile("default")
class DefaultStringService : StringService() {

    override fun reverse(string: String) = string.reversed()

}