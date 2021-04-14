package com.sdk.quran.network


import com.sdk.quran.models.Ayah
import com.google.gson.annotations.SerializedName
import com.sdk.quran.models.Edition
import com.sdk.quran.models.Surah
import retrofit2.Call
import retrofit2.http.*


/*
* Create By Gouse Mohiddin
* Made by MJ Creative Works
*/

interface APIInterface {

    @GET("surah")
    fun getListOfSurahs() : Call<BaseResponse<List<Surah>>>


    @GET("surah/{surah}/{version}")
    fun getAyahs(@Path("surah") surahNum : Int,@Path("version") version : String) : Call<BaseResponse<AyahResponse>>

}

data class UploadResponse(
        @SerializedName("status_code")
        var status: Int,
        @SerializedName("message")
        var message: String)

data class BaseResponse<T>(
        @SerializedName("success")
        var code: Int,
        @SerializedName("msg")
        var status: String,
        @SerializedName("data")
        var data: T,
)

data class AyahResponse(
        @SerializedName("number")
        var number: Int,
        @SerializedName("name")
        var name: String,
        @SerializedName("englishName")
        var englishName: String,
        @SerializedName("englishNameTranslation")
        var englishNameTranslation: String,
        @SerializedName("revelationType")
        var revelationType: String,
        @SerializedName("numberOfAyahs")
        var numberOfAyahs: Int,
        @SerializedName("ayahs")
        var ayahs: List<Ayah>,
        @SerializedName("edition")
        var edition: Edition,
)
