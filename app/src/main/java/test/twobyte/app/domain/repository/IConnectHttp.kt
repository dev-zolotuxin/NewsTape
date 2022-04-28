package test.twobyte.app.domain.repository

import test.twobyte.app.domain.model.NewsApi

interface IConnectHttp {
    suspend fun getNewsApi(): NewsApi
}