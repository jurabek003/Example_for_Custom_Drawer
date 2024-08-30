package uz.turgunboyevjurabek.exampleforcustomdrawer.presentation.state
import uz.turgunboyevjurabek.exampleforcustomdrawer.domein.models.LoremPicsumItem

sealed class LoremPicsumState {
    object Loading : LoremPicsumState()
    data class Success(val listOfCats: List<LoremPicsumItem>) : LoremPicsumState()
    data class Error(val exception: Exception) : LoremPicsumState()
}