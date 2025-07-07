package com.annalech.checkbin

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.annalech.checkbin.data.network.ApiFactory
import com.annalech.checkbin.databinding.ActivityMainBinding
import com.annalech.checkbin.databinding.BinSearchFragmentBinding
import com.annalech.checkbin.presentation.BinSearchFragment
import com.annalech.checkbin.presentation.ReportFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding?=null
    val binding: ActivityMainBinding
        get() = _binding ?: throw Exception("No ActivityMainBinding")





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState==null){
            Log.d("API_LOG","переход на фрагмент бин}")
            supportFragmentManager.beginTransaction()
                .add(R.id.main_container,BinSearchFragment.newInstance())
                .commit()
        }



        binding.buttonNavigation.setOnItemSelectedListener{ menu->
                when(menu.itemId){
                    R.id.search_bin_btn_menu ->{
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_container,BinSearchFragment.newInstance())
                            .commit()
                        Log.d("API_LOG","переход на фрагмент бин}")
                        true
                    }
                    R.id.reports_btn_menu -> {
                        Log.d("API_LOG","переход на фрагмент отчета}")
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_container,ReportFragment.newInstance())
                            .commit()
                        true
                    }
                    else ->false
                }
        }

    }




    override fun onDestroy() {
        Log.d("API_LOG","активити уничтожена")
        super.onDestroy()
        _binding = null
    }

}