package com.saraebadi.compose_coin.data.di

import com.google.gson.Gson
import com.saraebadi.compose_coin.data.service.MarketApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://api.coingecko.com/api/v3/"
    private const val API_KEY = "CG-LFeaPuTuNWrGPXc11aRwmq26"


    @Provides
    fun provideInterceptor(): Interceptor = Interceptor { chain ->
        val originalRequest = chain.request()
        val newRequest = originalRequest.newBuilder()
            .addHeader("content-type", "application/json")
            .addHeader("x-cg-demo-api-key", API_KEY)
            .build()
        chain.proceed(newRequest)
    }

    @Provides
    fun provideOkHttpClient(
        interceptor: Interceptor
    ) = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .addNetworkInterceptor(
            HttpLoggingInterceptor { message ->
                println("LOG-NET: $message")
            }.apply {
                level = HttpLoggingInterceptor.Level.BODY
            },
        )
        .build()

    @Provides
    fun provideGson(): Gson = Gson()

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gson: Gson
    ) : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
//            .addCallAdapterFactory(EitherCallAdapterFactory.create())
            .build()
    }

    @Provides
    fun provideCoinApi(retrofit: Retrofit) : MarketApi = retrofit.create(MarketApi::class.java)
}