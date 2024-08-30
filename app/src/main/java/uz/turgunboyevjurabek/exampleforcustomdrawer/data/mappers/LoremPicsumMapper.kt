package uz.turgunboyevjurabek.exampleforcustomdrawer.data.mappers

import uz.turgunboyevjurabek.exampleforcustomdrawer.data.dto.LoremPicsumItemDto
import uz.turgunboyevjurabek.exampleforcustomdrawer.domein.models.LoremPicsumItem

fun LoremPicsumItemDto.toDomain()= LoremPicsumItem(
    author = author,
    download_url = download_url,
    height = height,
    id = id,
    url = url,
    width=width
)
fun List<LoremPicsumItemDto>.toDomain()= map { it.toDomain() }
