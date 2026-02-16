package com.ebc.juegos_back.controller

import com.ebc.juegos_back.dto.NumberApiResponse
import com.ebc.juegos_back.service.LotteryService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["*"])
@RestController
@RequestMapping("/lottery/")
class LotteryController(
    private val lotteryService: LotteryService
) {
    @GetMapping("/{attempt}/digit-length/{length}")
    fun getWinnerNum(@PathVariable attempt: Int, @PathVariable length: Int): NumberApiResponse {
        return lotteryService.getWinnerNum(attempt, length);
    }
}