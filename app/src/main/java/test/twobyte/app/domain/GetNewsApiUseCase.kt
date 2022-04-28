package test.twobyte.app.domain

import test.twobyte.app.domain.model.NewsApi
import test.twobyte.app.domain.repository.IConnectHttp

class GetNewsApiUseCase(private val getNewsApiUseCase: IConnectHttp) {
    suspend fun execute(): NewsApi = getNewsApiUseCase.getNewsApi()
}