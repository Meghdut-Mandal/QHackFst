package com.android.qhackfst.network

import com.android.qhackfst.data.CovidRequest
import com.android.qhackfst.data.CovidResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST

interface CovidML {
    @POST("/optum")
    fun sendImage(@Body covidRequest: CovidRequest): Call<CovidResponse>
}