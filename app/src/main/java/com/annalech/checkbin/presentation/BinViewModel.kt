package com.annalech.checkbin.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.annalech.checkbin.data.network.ApiFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BinViewModel : ViewModel() {


    fun getBinInfo(bin: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                Log.d("API_LOG", "старт запроса во вью модель")

                // Выполнение запроса к API
                val info = ApiFactory.apiService.getBinInfo(bin)
                withContext(Dispatchers.Main) {
                    Log.d("API_LOG", "сделан запрос и дальше обработка ответа")

                    // Обработка успешного ответа
                    if (info.isSuccessful) {
                        Log.d("API_LOG", "Response: ${info.body()}")
                    } else {
                        Log.d("API_LOG", "Response code: ${info.code()}")
                    }
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

}