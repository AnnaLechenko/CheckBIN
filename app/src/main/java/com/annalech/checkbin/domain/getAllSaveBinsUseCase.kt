package com.annalech.checkbin.domain

import androidx.lifecycle.LiveData
import com.annalech.checkbin.data.database.BinInfoDBModel

class getAllSaveBinsUseCase (val repository: Repository){
    operator   fun invoke(): LiveData<List<BinInfoDBModel>> {
       return repository.getAllSaveBins()
    }

}