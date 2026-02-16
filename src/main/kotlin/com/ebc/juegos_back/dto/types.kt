package com.ebc.juegos_back.dto

data class Choices (
    val user: String,
    val cpu: String
)

data class NumberApiResponse(
    val message: String,
    val number: Int
)

data class GuessApiResponse(
    val message: String,
    val number: String
)

data class ChoicesApiResponse(
    val message: String,
    val result: Int,
    val choices: Choices?
)