package com.ebc.juegos_back.controller

import com.ebc.juegos_back.dto.ChoicesApiResponse
import com.ebc.juegos_back.service.EEDService
import com.ebc.juegos_back.service.GuessNumberService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["*"])
@RestController
@RequestMapping("/eed/")
class EEDController(
    private val eedService: EEDService
) {
    @GetMapping("/fight/{userChoice}")
    fun fight(@PathVariable userChoice: String): ChoicesApiResponse {
        return eedService.fight(userChoice);
    }
}