package com.ebc.juegos_back.controller

import com.ebc.juegos_back.dto.NumberApiResponse
import com.ebc.juegos_back.service.GuessNumberService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["*"])
@RestController
@RequestMapping("/guess/")
class GuessNumberController(
    private val guessNumberService: GuessNumberService
) {
    @GetMapping("/{attempt}/at-most/{maxNum}")
    fun attemptToGuess(@PathVariable attempt: Int, @PathVariable maxNum: Int): NumberApiResponse {
        return guessNumberService.attemptToGuess(attempt, maxNum);
    }
}
