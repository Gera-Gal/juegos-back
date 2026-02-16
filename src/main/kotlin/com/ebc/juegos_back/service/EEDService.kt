package com.ebc.juegos_back.service

import com.ebc.juegos_back.dto.Choices
import com.ebc.juegos_back.dto.ChoicesApiResponse
import org.springframework.stereotype.Service
import kotlin.random.Random

data class CustomResult (
    val gameResult: Int,
    val forUser: String,
    val forCpu: String,
)

@Service
class EEDService {
    private var cpuChoice: String = ""

    fun fightCpu(userChoice: String): CustomResult {
        var randomNumber = Random.nextInt(3);
        this.cpuChoice = when (randomNumber) {
            0 -> "SWORD"
            1 -> "SHIELD"
            2 -> "DRAGON"
            else -> ""
        }
        return when (userChoice to this.cpuChoice) {
            "SWORD" to "DRAGON" -> CustomResult(
                1,
                "Espada",
                "al Dragón"
            )
            "SWORD" to "SWORD" -> CustomResult(
                0,
                "Espada",
                "la Espada"
            )
            "SWORD" to "SHIELD" -> CustomResult(
                -1,
                "Espada",
                "El Escudo"
            )
            "SHIELD" to "SWORD" -> CustomResult(
                1,
                "Escudo",
                "a la Espada"
            )
            "SHIELD" to "SHIELD" -> CustomResult(
                0,
                "Escudo",
                "el Escudo"
            )
            "SHIELD" to "DRAGON" -> CustomResult(
                -1,
                "Escudo",
                "El Dragón"
            )
            "DRAGON" to "SHIELD" -> CustomResult(
                1,
                "Dragón",
                "al Escudo"
            )
            "DRAGON" to "DRAGON" -> CustomResult(
                0,
                "Dragón",
                "el Dragón"
            )
            "DRAGON" to "SWORD" -> CustomResult(
                -1,
                "Dragón",
                "La Espada"
            )
            else -> CustomResult(
                2,
                "",
                ""
            )
        }
    }

    fun fight(userChoice: String): ChoicesApiResponse {
        val gameResult = fightCpu(userChoice);
        if(gameResult.gameResult == 1) {
            return ChoicesApiResponse(
                message = "¡Tu ${gameResult.forUser} venció ${gameResult.forCpu} del CPU!",
                result = 1,
                choices = Choices(
                    user = userChoice,
                    cpu = this.cpuChoice
                )
            );
        } else if(gameResult.gameResult == 0) {
            return ChoicesApiResponse(
                message = "¡Tu ${gameResult.forUser} empató con ${gameResult.forCpu} del CPU!",
                result = 0,
                choices = Choices(
                    user = userChoice,
                    cpu = this.cpuChoice
                )
            );
        } else if(gameResult.gameResult == -1) {
            return ChoicesApiResponse(
                message = "¡${gameResult.forCpu} del CPU venció a tu ${gameResult.forUser}!",
                result = -1,
                choices = Choices(
                    user = userChoice,
                    cpu = this.cpuChoice
                )
            );
        } else {
            return ChoicesApiResponse(
                message = "¡Error!",
                result = 2,
                choices = null
            );
        }
    }
}