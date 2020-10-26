package dev.mrthegood.week_three.util.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.IllegalArgumentException

/**
 * Created by maartendegoede on 05/10/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
class IllegalBankAccountException(message: String) : IllegalArgumentException(message)