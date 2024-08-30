package uz.turgunboyevjurabek.exampleforcustomdrawer.domein.repository

import uz.turgunboyevjurabek.exampleforcustomdrawer.core.utils.Resource
import uz.turgunboyevjurabek.exampleforcustomdrawer.data.dto.LoremPicsumItemDto
import uz.turgunboyevjurabek.exampleforcustomdrawer.domein.models.LoremPicsumItem

interface MyRepository {
    suspend fun getLorem(): Resource<List<LoremPicsumItem>>
}