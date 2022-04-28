package test.twobyte.app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import test.twobyte.app.domain.GetNewsApiUseCase
import test.twobyte.app.domain.model.NewsApi

class MainViewModel(
    private val getNewsApiUseCase: GetNewsApiUseCase
) : ViewModel() {


    private var _dataNewsApi = MutableStateFlow<NewsApi?>(null)
    val dataNewsApi: StateFlow<NewsApi?>
        get() = _dataNewsApi.asStateFlow()

    init {
        viewModelScope.launch {
            _dataNewsApi.value = getNewsApiUseCase.execute()
        }
    }
}