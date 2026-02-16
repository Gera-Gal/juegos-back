package com.ebc.juegos_back.controller

import com.ebc.juegos_back.dto.NumberApiResponse
import com.ebc.juegos_back.service.LotteryService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["*"])
@RestController
@RequestMapping("/lottery")
class LotteryController(
    private val lotteryService: LotteryService
) {
    @GetMapping
    fun getWinnerNum(@RequestParam attempt: Int, @RequestParam digitLength: Int): NumberApiResponse {
        return lotteryService.getWinnerNum(attempt, digitLength);
    }
}