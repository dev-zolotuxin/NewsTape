package test.twobyte.app.data.api

import retrofit2.http.GET
import test.twobyte.app.domain.model.NewsApi

interface HttpService {

    @GET("v2/everything?q=apple&from=2022-04-12&to=2022-04-12&sortBy=popularity&apiKey=413c0c7dc6be4dda99471c262d6d00fe")
    suspend fun getNewsApi(): NewsApi
}