package uz.turgunboyevjurabek.exampleforcustomdrawer.data.dto

import uz.turgunboyevjurabek.exampleforcustomdrawer.domein.models.LoremPicsum

data class LoremPicsumDtoList(
    val loremPicsum: ArrayList<LoremPicsumItemDto>
)

data class LoremPicsumItemDto(
    val author: String,
    val download_url: String,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)
