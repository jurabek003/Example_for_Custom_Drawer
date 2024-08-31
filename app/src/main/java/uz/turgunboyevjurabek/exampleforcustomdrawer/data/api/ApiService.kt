package uz.turgunboyevjurabek.exampleforcustomdrawer.data.api

import retrofit2.http.GET
import uz.turgunboyevjurabek.exampleforcustomdrawer.data.dto.LoremPicsumItemDto
import uz.turgunboyevjurabek.exampleforcustomdrawer.domein.models.LoremPicsum

interface ApiService {
    @GET("list")
    suspend fun getLorem(): List<LoremPicsumItemDto>

}