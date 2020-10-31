package com.android.youtubesearch.network

import com.android.youtubesearch.models.ResponseModel
import com.android.youtubesearch.network.APIClient.SCH
import com.android.youtubesearch.network.APIClient.mx
import com.android.youtubesearch.network.APIClient.part
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

interface APIInterface {
    @GET("${SCH}+${part}")
    fun searchVideos(
        @Path("key") key: String?,
        @Path("q") q: String?
    ): Call<ResponseModel>

    @GET("${SCH}+${part}+${mx}")
    fun searchVideo(@Query("key") key: String?,@Query("q") q : String): Call<ResponseModel>
}