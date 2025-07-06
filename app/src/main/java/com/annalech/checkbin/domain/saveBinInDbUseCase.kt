package com.annalech.checkbin.domain
import com.annalech.checkbin.data.database.BinInfoDBModel
import javax.inject.Inject

class saveBinInDbUseCase @Inject constructor(val repository: Repository) {
    operator suspend fun invoke(bin:BinInfoDBModel){
        repository.saveBinInDb(bin)
    }

}