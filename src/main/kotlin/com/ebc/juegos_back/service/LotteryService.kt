package com.ebc.juegos_back.service

import com.ebc.juegos_back.dto.GuessApiResponse
import com.ebc.juegos_back.dto.NumberApiResponse
import org.springframework.stereotype.Service
import kotlin.math.pow
import kotlin.random.Random

@Service
class LotteryService {
    fun getWinnerNum(attempt: String, length: Int): GuessApiResponse {
        var winnerString = "";
        while (winnerString.length < length) {
            winnerString += Random.nextInt(0, 10);
        }

        val totalCombinations = 10.0.pow(length);
        val odds = (1.0 / totalCombinations) * 100;

        if(winnerString == attempt) {
            return GuessApiResponse(
                message = "¡Tenías ${odds}% de probabilidades y ganaste!",
                number = winnerString
            );
        } else {
            return GuessApiResponse(
                message = "No te preocupes, el ${100 - odds}% de números eran perdedores" ,
                number = winnerString
            );
        }
    }
}