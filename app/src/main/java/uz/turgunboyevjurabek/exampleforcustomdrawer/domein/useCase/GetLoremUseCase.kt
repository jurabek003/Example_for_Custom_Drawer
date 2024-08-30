package uz.turgunboyevjurabek.exampleforcustomdrawer.domein.useCase

import uz.turgunboyevjurabek.exampleforcustomdrawer.domein.repository.MyRepository
import javax.inject.Inject

class GetLoremUseCase @Inject constructor(
    private val myRepository: MyRepository
) {
    suspend fun execute() = myRepository.getLorem()
}