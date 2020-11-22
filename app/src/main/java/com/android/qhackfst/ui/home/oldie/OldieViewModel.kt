package com.android.qhackfst.ui.home.oldie

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.qhackfst.network.VisionAINetwork
import com.android.qhackfst.network.VisionResponse
import com.android.qhackfst.util.createTempImage
import com.google.gson.Gson
import okhttp3.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

class OldieViewModel(val app: Application) : AndroidViewModel(app) {
    val heartRateMessage = MutableLiveData<String>()
    val visionAIMessage = MutableLiveData<String>()


    fun prepareFilePart(fileUri: Uri): RequestBody {
        val imageFile = app.createTempImage(fileUri)
        val requestBody = RequestBody.create(MediaType.parse("image/jpeg")!!, imageFile)
        return requestBody
    }


//    fun uploadImage(image: Uri) {
//
//        val okHttpClient = OkHttpClient.Builder()
//            .callTimeout(60, TimeUnit.MINUTES)
//            .readTimeout(60, TimeUnit.MINUTES)
//            .connectTimeout(60, TimeUnit.MINUTES).build()
//
//        val retorfit = Retrofit.Builder()
//            .client(okHttpClient)
//            .addConverterFactory(ScalarsConverterFactory.create())
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl("http://visionaiapp.herokuapp.com").build()
//        val network = retorfit.create(VisionAINetwork::class.java)
//        val filePart = prepareFilePart(image)
//
//        network.send(filePart, "app").enqueue(object : Callback<String?> {
//            override fun onResponse(
//                call: Call<String?>,
//                response: Response<String?>
//            ) {
//                val body = response.body()
////                if (response.isSuccessful && body != null) {
////                    visionAIMessage.postValue(body.caption)
////                } else {
////                    visionAIMessage.postValue("Error in response")
////                }
//            }
//
//            override fun onFailure(call: Call<String?>, t: Throwable) {
//                visionAIMessage.postValue("Error in response")
//            }
//        })
//    }


    fun uploadImage2(fileUri: Uri) {
        val imageFile = app.createTempImage(fileUri)
        visionAIMessage.postValue("Processing Image...")

        val client = OkHttpClient().newBuilder()
            .callTimeout(60, TimeUnit.MINUTES)
            .readTimeout(60, TimeUnit.MINUTES)
            .connectTimeout(60, TimeUnit.MINUTES).build()

        val body: RequestBody = MultipartBody.Builder().setType(MultipartBody.FORM)
            .addFormDataPart(
                "input_image", "/C:/Users/KIIT/Downloads/test.jpeg",
                RequestBody.create(
                    MediaType.parse("application/octet-stream"),
                    imageFile
                )
            )
            .addFormDataPart("platform", "app")
            .build()
        val request: Request = Request.Builder()
            .url("http://visionaiapp.herokuapp.com/")
            .method("POST", body)
            .build()
        client.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                println("com.android.qhackfst.ui.home.oldie>>OldieViewModel>onFailure  ")
            }

            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                val string = response.body()?.string()
                val vision = Gson().fromJson(string, VisionResponse::class.java)
                if (vision != null) {
                    visionAIMessage.postValue(vision.caption)
                }
                println("com.android.qhackfst.ui.home.oldie>>OldieViewModel>onResponse  ")
            }
        })
    }


}