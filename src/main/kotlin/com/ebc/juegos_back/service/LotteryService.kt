package com.ebc.juegos_back.service

import com.ebc.juegos_back.dto.NumberApiResponse
import org.springframework.stereotype.Service
import kotlin.math.pow
import kotlin.random.Random

@Service
class LotteryService {
    fun getWinnerNum(attempt: Int, length: Int): NumberApiResponse {
        var winnerString = "";
        while (winnerString.length < length) {
            winnerString += Random.nextInt(0, 10);
        }

        val winnerNum: Int = winnerString.toInt();

        val totalCombinations = 10.0.pow(length);
        val odds = (1.0 / totalCombinations) * 100;

        if(winnerNum == attempt) {
            return NumberApiResponse(
                message = "¡Tenías ${odds}% de probabilidades y ganaste!",
                number = winnerNum
            );
        } else {
            return NumberApiResponse(
                message = "No te preocupes, el ${100 - odds}% de números eran perdedores" ,
                number = winnerNum
            );
        }
    }
}