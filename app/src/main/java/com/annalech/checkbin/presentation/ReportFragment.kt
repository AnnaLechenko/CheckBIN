package com.annalech.checkbin.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.annalech.checkbin.R
import com.annalech.checkbin.databinding.BinSearchFragmentBinding
import com.annalech.checkbin.databinding.SearchReportFragmentBinding

class ReportFragment :Fragment(R.layout.search_report_fragment){

    private var _binding: SearchReportFragmentBinding? = null
    val binding: SearchReportFragmentBinding
        get() = _binding ?: throw Exception("No SearchReportFragmentBinding")


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SearchReportFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    companion object{

        fun newInstance():ReportFragment{
            return ReportFragment()
        }
    }
}