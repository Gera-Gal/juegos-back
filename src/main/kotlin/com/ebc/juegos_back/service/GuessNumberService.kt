package com.ebc.juegos_back.service

import com.ebc.juegos_back.dto.NumberApiResponse
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class GuessNumberService {
    private var secretNum: Int = 0;

    private fun generateSecretNum(maxNumber: Int) {
        secretNum = Random.nextInt(maxNumber + 1);
    }

    fun attemptToGuess(attempt: Int, maxNum: Int): NumberApiResponse {
        generateSecretNum(maxNum);
        if (attempt == secretNum) {
            return NumberApiResponse(
                message = "¡Tienes el don de la clarividencia!",
                number = secretNum
            );
        } else {
            return NumberApiResponse(
                message = "¡Abre tu ojo interior!",
                number = secretNum
            )
        }
    }
}