package com.annalech.checkbin.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.annalech.checkbin.R
import com.annalech.checkbin.databinding.BinSearchFragmentBinding
import com.annalech.checkbin.databinding.SearchReportFragmentBinding

class BinSearchFragment :Fragment(R.layout.bin_search_fragment){

    private var _binding: BinSearchFragmentBinding?=null
    val binding: BinSearchFragmentBinding
        get() = _binding ?: throw Exception("No BinSearchFragmentBinding")



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BinSearchFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{

        fun newInstance():BinSearchFragment{
            return BinSearchFragment()
        }
    }
}