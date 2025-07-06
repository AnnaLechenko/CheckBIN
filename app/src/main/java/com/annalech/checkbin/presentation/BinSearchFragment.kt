package com.annalech.checkbin.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.annalech.checkbin.R
import com.annalech.checkbin.databinding.BinSearchFragmentBinding

class BinSearchFragment : Fragment(R.layout.bin_search_fragment) {

    private var _binding: BinSearchFragmentBinding? = null
    val binding: BinSearchFragmentBinding
        get() = _binding ?: throw Exception("No BinSearchFragmentBinding")


    val viewModel by lazy {ViewModelProvider(this)[BinViewModel::class.java]}


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
        viewModel.getBinInfo("45717360")
        Log.d("API_LOG","сделан запрос во вью модель во фрагменте")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        fun newInstance(): BinSearchFragment {
            Log.d("API_LOG","создан фрагмент бин")
            return BinSearchFragment()

        }
    }
}