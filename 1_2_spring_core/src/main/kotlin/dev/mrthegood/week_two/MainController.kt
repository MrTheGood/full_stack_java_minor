package dev.mrthegood.week_two

import dev.mrthegood.week_two.service.StringService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Created by maartendegoede on 21/09/2020.
 * Copyright © 2020 Maarten de Goede. All rights reserved.
 */
@Controller
class MainController {

    @Autowired
    private lateinit var stringService: StringService
    @Autowired
    private lateinit var stringRepository: StringRepository


    @GetMapping("/reverse/{input}")
    @ResponseBody
    fun getReverse(@PathVariable input: String) =
        stringService.reverse(input)

    @GetMapping("/count/{input}")
    @ResponseBody
    fun getCount(@PathVariable input: String) =
        stringRepository.count(input)
}