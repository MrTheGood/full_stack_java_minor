package dev.mrthegood.week_four.models

import javax.persistence.Embeddable


/**
 * Created by maartendegoede on 05/10/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
@Embeddable
class Address {
    // In the Netherlands the combination of house number and postal code is unique.
    // Therefore those fields are already enough to figure out all the other required data.
    lateinit var houseNumber: String
    lateinit var postalCode: String
}