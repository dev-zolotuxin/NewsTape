package test.twobyte.app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import test.twobyte.app.data.api.ConnectHttp
import test.twobyte.app.domain.GetNewsApiUseCase

class MainViewModelFactory : ViewModelProvider.Factory {

    private val connectHttp by lazy {
        ConnectHttp()
    }

    private val getNewsApiUseCase by lazy {
        GetNewsApiUseCase(getNewsApiUseCase = connectHttp)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getNewsApiUseCase = getNewsApiUseCase
        ) as T
    }
}