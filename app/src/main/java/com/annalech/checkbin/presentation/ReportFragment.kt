package com.annalech.checkbin.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.annalech.checkbin.R
import com.annalech.checkbin.databinding.SearchReportFragmentBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ReportFragment : Fragment(R.layout.search_report_fragment) {

    private var _binding: SearchReportFragmentBinding? = null
    val binding: SearchReportFragmentBinding
        get() = _binding ?: throw Exception("No SearchReportFragmentBinding")

    private lateinit var adapter: BinAdapter

   private val viewModel: BinViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SearchReportFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initalizeRecyclerView()

        viewModel.listSearchBins.observe(viewLifecycleOwner) { listBins ->
            adapter.differ.submitList(listBins)
        }

    }

    private fun initalizeRecyclerView() {
        adapter = BinAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {

        fun newInstance(): ReportFragment {
            return ReportFragment()
        }
    }
}