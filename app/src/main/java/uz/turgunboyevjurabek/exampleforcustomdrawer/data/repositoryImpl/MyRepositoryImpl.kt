package uz.turgunboyevjurabek.exampleforcustomdrawer.data.repositoryImpl

import uz.turgunboyevjurabek.exampleforcustomdrawer.core.utils.Resource
import uz.turgunboyevjurabek.exampleforcustomdrawer.data.api.ApiService
import uz.turgunboyevjurabek.exampleforcustomdrawer.data.dto.LoremPicsumItemDto
import uz.turgunboyevjurabek.exampleforcustomdrawer.data.mappers.toDomain
import uz.turgunboyevjurabek.exampleforcustomdrawer.domein.models.LoremPicsumItem
import uz.turgunboyevjurabek.exampleforcustomdrawer.domein.repository.MyRepository

class MyRepositoryImpl(private val apiService: ApiService):MyRepository {
    override suspend fun getLorem(): Resource<List<LoremPicsumItem>> {
        return try {
            Resource.Success(apiService.getLorem().toDomain())

        }
        catch (exception:Exception){
            Resource.Error(exception)
        }
    }

}