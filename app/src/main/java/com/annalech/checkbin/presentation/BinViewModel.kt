package com.annalech.checkbin.presentation

import android.util.Log

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.annalech.checkbin.data.database.BinInfoDBModel
import com.annalech.checkbin.data.network.ApiFactory
import com.annalech.checkbin.data.network.model.BinInfo
import com.annalech.checkbin.domain.getAllSaveBinsUseCase
import com.annalech.checkbin.domain.saveBinInDbUseCase
import com.annalech.checkbin.utility.Mapper
import dagger.hilt.android.lifecycle.HiltViewModel


import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class BinViewModel @Inject constructor(
     private val getBinuseCase: getAllSaveBinsUseCase,
     private val saveBinUseCase: saveBinInDbUseCase
) : ViewModel() {


    private val _isError = MutableLiveData<Boolean>()
    val isError: LiveData<Boolean>
        get() = _isError


    private val _binInfo = MutableLiveData<BinInfo>()
    val binInfo: LiveData<BinInfo>
        get() = _binInfo

    //получем все Bin из базы  даннных
    val listSearchBins = getBinuseCase.invoke()
    val scope = CoroutineScope(Dispatchers.Default)

    fun getBinInfo(bin: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                Log.d("API_LOG", "старт запроса во вью модель")

                // Выполнение запроса к API
                val response = ApiFactory.apiService.getBinInfo(bin)

                Log.d("API_LOG", "сделан запрос и дальше обработка ответа")

                // Обработка успешного ответа
                if (response.isSuccessful) {
                    val info = response.body()
                    info?.let { it ->
                        _binInfo.postValue(it)
                        _isError.postValue(false)
                        Log.d("API_LOG", "Response: ${info}")

                      val dbModel =   Mapper.formatBinInfoInDbModel(bin=bin, binInfo = it)
                        saveBinInfo(dbModel)
                    } ?: run {
                        _isError.postValue(true)
                        Log.d("API_LOG", "Response null: ${info}")
                    }


                } else {
                    _isError.postValue(true)
                    Log.d("API_LOG", "Response code: ${response.code()}")
                }


            } catch (e: Exception) {
                // Логирование ошибок
                withContext(Dispatchers.Main) {
                    Log.e("API_LOG", "Ошибка запроса: ${e.localizedMessage}")
                }
            }
            Log.d("API_LOG", "ответ апи обработан")
        }





    }
    fun saveBinInfo(dbModel :BinInfoDBModel) {
        scope.launch {
            saveBinUseCase.invoke(dbModel)
        }
    }

}