package com.example.memes.data.mapper

import com.badiniibrahim.myapplication.domain.models.ApiError
import com.badiniibrahim.myapplication.domain.models.NetworkError
import retrofit2.HttpException
import java.io.IOException

fun Throwable.toGeneralError(): NetworkError {
    val error = when (this) {
        is IOException -> ApiError.NetworkError
        is HttpException -> ApiError.UnknownResponse
        else -> ApiError.UnknownError
    }
    return NetworkError(
        error = error,
        t = this
    )
}