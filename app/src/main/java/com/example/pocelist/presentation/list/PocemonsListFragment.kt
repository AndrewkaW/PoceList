package com.example.pocelist.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pocelist.R
import com.example.pocelist.databinding.FragmentPocemonsListBinding
import com.example.pocelist.domain.model.Pocemon
import com.example.pocelist.presentation.details.PocemonDetailsFragment.Companion.POCEMON_NAME
import com.example.pocelist.presentation.list.adaptor.PocemonsListAdaptor
import com.example.pocelist.presentation.list.view_model.PocemonsListViewModel
import com.example.pocelist.presentation.list.view_model.model.PocemonsListState
import com.example.pocelist.util.Resource
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
    ): View {
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

            is PocemonsListState.Error -> {
                binding.tvError.visibility = View.VISIBLE
                binding.tvError.text = when (state.massage) {
                    Resource.CONNECTION_ERROR ->
                        getText(R.string.connecion_error)

                    else -> getText(R.string.not_found)
                }
                binding.ivRefresh.visibility = View.VISIBLE
                binding.rvPocemons.visibility = View.GONE
                binding.progressBar.visibility = View.GONE

            }

            is PocemonsListState.Loading -> {
                binding.tvError.visibility = View.GONE
                binding.ivRefresh.visibility = View.GONE
                binding.rvPocemons.visibility = View.GONE
                binding.progressBar.visibility = View.VISIBLE
            }

            is PocemonsListState.PocemonsResult -> {
                binding.tvError.visibility = View.GONE
                binding.ivRefresh.visibility = View.GONE
                binding.rvPocemons.visibility = View.VISIBLE
                binding.progressBar.visibility = View.GONE
                rvAdaptor.pocemons = state.pocemons
                rvAdaptor.notifyDataSetChanged()
            }
        }
    }

    private fun clickOnPocemon(pocemon: Pocemon) {
        findNavController().navigate(
            R.id.action_pocemonsListFragment_to_pocemonDetailsFragment,
            Bundle().apply { putString(POCEMON_NAME, pocemon.name) }
        )
    }
}