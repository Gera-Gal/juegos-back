package com.ebc.juegos_back.controller

import com.ebc.juegos_back.dto.NumberApiResponse
import com.ebc.juegos_back.service.GuessNumberService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["*"])
@RestController
@RequestMapping("/guess")
class GuessNumberController(
    private val guessNumberService: GuessNumberService
) {
    @GetMapping
    fun attemptToGuess(@RequestParam attempt: Int, @RequestParam maxNum: Int): NumberApiResponse {
        return guessNumberService.attemptToGuess(attempt, maxNum);
    }
}
