package com.annalech.checkbin.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.annalech.checkbin.R
import com.annalech.checkbin.databinding.BinSearchFragmentBinding

class BinSearchFragment : Fragment(R.layout.bin_search_fragment) {

    private var _binding: BinSearchFragmentBinding? = null
    val binding: BinSearchFragmentBinding
        get() = _binding ?: throw Exception("No BinSearchFragmentBinding")


    val viewModel by lazy { ViewModelProvider(this)[BinViewModel::class.java] }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BinSearchFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnSearch.setOnClickListener {
            val inputText = binding.etBinInput.text
            if (inputText.isNotEmpty() && inputText.isDigitsOnly() && inputText.length in 6..8) {
                viewModel.getBinInfo(inputText.toString()) //"45717360" из примера апи
                Log.d("API_LOG", "сделан запрос во вью модель во фрагменте")
            } else {
                Toast.makeText(
                    requireContext(),
                    "Данные введены не верно",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }


        viewModel.binInfo.observe(viewLifecycleOwner) {
            info ->

            binding.tvErrorMessage.visibility = View.GONE
            binding.resultScrollView.visibility = View.VISIBLE

            val statusPrepaid = if(info.prepaid == true){
                "Да"
            }else{
                "Информация отсутствует"
            }

            binding.tvScheme.text = "Тип карты: ${info.scheme ?: "Информация отсутствует"}"
            binding.tvBrand.text =  "Бренд: ${info.brand ?: "Информация отсутствует"}"
            binding.tvType.text = "Тип: ${info.type ?: "Информация отсутствует"}"
            binding.tvPrepaid.text = "Предоплаченная: $statusPrepaid"
            binding.tvCountry.text = "Страна: ${info.country?.name ?: "Информация отсутствует"}"

            binding.tvBankName.text = "Банк: ${info.bank?.name ?: "Информация отсутствует"}"
            binding.tvBankCity.text = "Город банка: ${info.bank?.city ?: "Информация отсутствует"}"
            binding.tvBankUrl.text =  "Сайт: ${info.bank?.url ?: "Информация отсутствует"}"
            binding.tvBankPhone.text = "Телефон: ${info.bank?.phone ?: "Информация отсутствует"}"

        }

        viewModel.isError.observe(viewLifecycleOwner){isError ->
            if (isError){
                binding.resultScrollView.visibility = View.GONE
                binding.tvErrorMessage.visibility = View.VISIBLE
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        fun newInstance(): BinSearchFragment {
            Log.d("API_LOG", "создан фрагмент бин")
            return BinSearchFragment()

        }
    }
}