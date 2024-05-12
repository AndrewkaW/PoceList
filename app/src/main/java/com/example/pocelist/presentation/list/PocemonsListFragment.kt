package com.example.pocelist.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pocelist.databinding.FragmentPocemonsListBinding
import com.example.pocelist.domain.model.Pocemon
import com.example.pocelist.presentation.list.adaptor.PocemonsListAdaptor
import com.example.pocelist.presentation.list.view_model.PocemonsListViewModel
import com.example.pocelist.presentation.list.view_model.model.PocemonsListState
import org.koin.androidx.viewmodel.ext.android.viewModel

class PocemonsListFragment : Fragment() {

    private var _binding: FragmentPocemonsListBinding? = null
    private val binding get() = _binding!!

    private val rvAdaptor = PocemonsListAdaptor { clickOnPocemon(it) }

    private val vM: PocemonsListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPocemonsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vM.stateLiveData.observe(viewLifecycleOwner) {
            showState(it)
        }
        binding.rvPocemons.apply {
            layoutManager = LinearLayoutManager(requireContext())
            binding.rvPocemons.adapter = rvAdaptor
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showState(state: PocemonsListState) {
        when (state) {
            is PocemonsListState.Error -> TODO()
            PocemonsListState.Loading -> TODO()
            is PocemonsListState.PocemonsResult -> {
                rvAdaptor.pocemons = state.pocemons
                rvAdaptor.notifyDataSetChanged()
            }
        }
    }

    private fun clickOnPocemon(pocemon: Pocemon) {
        //переход на детали
    }
}