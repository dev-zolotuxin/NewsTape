package test.twobyte.app.data.api

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import test.twobyte.app.domain.model.NewsApi
import test.twobyte.app.domain.repository.IConnectHttp

class ConnectHttp : IConnectHttp {
    private lateinit var retrofitClient: HttpService
    private var baseUrl: String = "https://newsapi.org/"

    private fun initRetrofit() {
        retrofitClient = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(JacksonConverterFactory.create(jacksonObjectMapper()))
            .build()
            .create(HttpService::class.java)
    }

    override suspend fun getNewsApi(): NewsApi = withContext(Dispatchers.IO) {
        initRetrofit()
        retrofitClient.getNewsApi()
    }

}