package com.annalech.checkbin.domain
import com.annalech.checkbin.data.database.BinInfoDBModel

class saveBinInDbUseCase(val repository: Repository) {
    operator suspend fun invoke(bin:BinInfoDBModel){
        repository.saveBinInDb(bin)
    }

}