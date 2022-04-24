package com.scribblex.creditscore.di

import com.scribblex.creditscore.data.remote.CreditApiService
import com.scribblex.creditscore.data.remote.CreditApiServiceImpl
import com.scribblex.creditscore.data.repository.CreditRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = setupRetrofit()

    @Provides
    fun provideApiService(retrofit: Retrofit): CreditApiService =
        retrofit.create(CreditApiService::class.java)

    @Singleton
    @Provides
    fun provideRemoteDataSource(apiService: CreditApiService) = CreditApiServiceImpl(apiService)

    @Singleton
    @Provides
    fun provideCreditRepository(apiImpl: CreditApiServiceImpl) = CreditRepositoryImpl(apiImpl)

    private fun setupRetrofit(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://android-interview.s3.eu-west-2.amazonaws.com/")
            .client(client)
            .build()
    }

}