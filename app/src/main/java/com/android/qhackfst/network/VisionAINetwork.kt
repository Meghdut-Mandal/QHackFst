package com.android.qhackfst.network

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

data class VisionResponse(val caption: String)

interface VisionAINetwork {

    @Multipart
    @POST("/")
    fun send(
        @Part("input_image") file: RequestBody,
        @Part("platform") platform: String
    ): Call<String>

}