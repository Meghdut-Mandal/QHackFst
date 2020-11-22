package com.android.qhackfst.network

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

data class VisionResponse(val caption: String)

interface VisionAI {

    @Multipart
    @POST("/")
    fun send(
        @Part("imput_image") file: RequestBody,
        @Part("platform") app: String = "app"
    ): Call<VisionResponse>

}