package com.example.pocelist.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.pocelist.R
import com.example.pocelist.databinding.FragmentPocemonDetailsBinding
import com.example.pocelist.presentation.details.model.DetailsState
import com.example.pocelist.presentation.details.view_model.PocemonDetailsViewModel
import com.example.pocelist.util.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel

class PocemonDetailsFragment : Fragment() {

    private var _binding: FragmentPocemonDetailsBinding? = null
    private val binding get() = _binding!!

    private val vM: PocemonDetailsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPocemonDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vM.stateLiveData.observe(viewLifecycleOwner) {
            showState(it)
        }
        arguments?.getString(POCEMON_NAME)?.let { vM.getPocemonDetails(it) }

        binding.toolbarId.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun showState(state: DetailsState) {
        when (state) {
            is DetailsState.Error -> {
                binding.apply {
                    progBar.visibility = View.GONE
                    groupInfo.visibility = View.GONE
                    when (state.massage) {
                        Resource.NOT_FOUND -> {
                            tvError.text = getText(R.string.not_found)
                        }

                        Resource.CONNECTION_ERROR -> {
                            tvError.text = getText(R.string.connecion_error)
                        }
                    }
                }
            }

            is DetailsState.Loading -> {
                binding.apply {
                    progBar.visibility = View.VISIBLE
                    groupInfo.visibility = View.GONE
                    tvError.visibility = View.GONE
                }
            }

            is DetailsState.Info -> {
                binding.apply {
                    progBar.visibility = View.GONE
                    groupInfo.visibility = View.VISIBLE
                    tvError.visibility = View.GONE
                    Glide.with(ivArtwork)
                        .load(state.details.imageUrl)
                        .placeholder(R.drawable.default_art_work)
                        .into(ivArtwork)

                    tvHeight.text = state.details.height.toString()
                    tvWeight.text = state.details.weight.toString()
                    tvTypes.text = state.details.types
                    tvAbilities.text = state.details.abilities
                    tvName.text = state.details.name
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val POCEMON_NAME = "pocemonName"
    }
}