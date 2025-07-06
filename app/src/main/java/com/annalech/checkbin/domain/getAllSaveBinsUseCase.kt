package com.annalech.checkbin.domain

import androidx.lifecycle.LiveData
import com.annalech.checkbin.data.database.BinInfoDBModel
import javax.inject.Inject

class getAllSaveBinsUseCase @Inject constructor(val repository: Repository){
    operator   fun invoke(): LiveData<List<BinInfoDBModel>> {
       return repository.getAllSaveBins()
    }

}