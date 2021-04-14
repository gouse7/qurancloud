package com.mjcwrks.quran.network


import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class RetrofitModule {

    companion object {
        const val BASE_URL = "http://api.alquran.cloud/v1/"
    }

    @Singleton
    @Provides
    fun getApiInterface(retrofit: Retrofit) = retrofit.create(APIInterface::class.java)

    @Singleton
    @Provides
    fun provideGson(): Gson = Gson()


    @Singleton
    @Provides
    fun getRetrofit(): Retrofit {


        var gson = GsonBuilder()
                .setLenient()
                .create()
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                //.baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(getOkHttpClient()).build()
    }

    @Singleton
    @Provides
    fun getOkHttpClient(): OkHttpClient {
/*        val lgg = HttpLoggingInterceptor()
        lgg.level = (HttpLoggingInterceptor.Level.BODY)*/

        return OkHttpClient.Builder().build()
    }


}
