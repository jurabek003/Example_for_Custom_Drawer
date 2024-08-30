package uz.turgunboyevjurabek.exampleforcustomdrawer.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uz.turgunboyevjurabek.exampleforcustomdrawer.core.utils.Resource
import uz.turgunboyevjurabek.exampleforcustomdrawer.domein.models.LoremPicsumItem
import uz.turgunboyevjurabek.exampleforcustomdrawer.domein.useCase.GetLoremUseCase
import uz.turgunboyevjurabek.exampleforcustomdrawer.presentation.state.LoremPicsumState
import javax.inject.Inject

@HiltViewModel
class GetLoremViewModel @Inject constructor(
    private val  getLoremUseCase: GetLoremUseCase
): ViewModel() {
    private val _state= MutableStateFlow<LoremPicsumState>(LoremPicsumState.Loading)
    val state = _state
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = LoremPicsumState.Loading
        )

    fun fetchLorem(){
        viewModelScope.launch {
            val result = getLoremUseCase.execute()
            handleGetAllProductResponse(result)
        }
    }

    private fun handleGetAllProductResponse(result: Resource<List<LoremPicsumItem>>) {
        when(result){
            is Resource.Success -> setProductState(LoremPicsumState.Success(result.data))
            is Resource.Error -> setProductState(LoremPicsumState.Error(result.exception))
        }
    }

    private fun setProductState(state: LoremPicsumState) {
        _state.update {
            state
        }
    }


}