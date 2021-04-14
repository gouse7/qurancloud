package com.sdk.quran.common

import android.util.Log
import com.sdk.quran.models.Surah
import com.sdk.quran.network.AyahResponse
import com.sdk.quran.network.BaseResponse
import com.sdk.quran.network.RetrofitModule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/*
* Create By Gouse Mohiddin
* Made by MJ Creative Works
*/
class Quran {

    companion object{
        var apiInterface = RetrofitModule().getApiInterface(
                RetrofitModule().getRetrofit()
        )

        val instance = Quran()

        fun surahList(callback: SurahCallback){
            Log.d("BOOK", "Started")
            apiInterface.getListOfSurahs().enqueue(object : retrofit2.Callback<BaseResponse<List<Surah>>> {

                override fun onResponse(call: Call<BaseResponse<List<Surah>>>, response: Response<BaseResponse<List<Surah>>>) {
                    var res: BaseResponse<List<Surah>> = response.body()!!
                    if (response.code() == 200) {
                        callback.success(res.data)
                    }
                    Log.d("BOOK", res.toString())
                }

                override fun onFailure(call: Call<BaseResponse<List<Surah>>>, t: Throwable) {
                    callback.failure(t)
                    Log.d("BOOK", "Failed", t)
                }

            })

        }

        fun ayahList(surah: Int, callback: AyahCallback){

            apiInterface.getAyahs(surah,"ar.alafasy").enqueue(object : Callback<BaseResponse<AyahResponse>> {
                override fun onResponse(call: Call<BaseResponse<AyahResponse>>, response: Response<BaseResponse<AyahResponse>>) {
                    var res: BaseResponse<AyahResponse> = response.body()!!
                    if (response.code() == 200) {
                        callback.success(res.data.ayahs)
                    }
                }

                override fun onFailure(call: Call<BaseResponse<AyahResponse>>, t: Throwable) {
                    Log.d("AYAH", "error", t)
                }

            })

        }
    }



}