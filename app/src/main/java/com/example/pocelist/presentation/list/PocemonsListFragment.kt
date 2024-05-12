package com.example.pocelist.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pocelist.databinding.FragmentPocemonsListBinding
import com.example.pocelist.domain.model.Pocemon
import com.example.pocelist.presentation.list.adaptor.PocemonsListAdaptor

class PocemonsListFragment : Fragment() {

    private var _binding: FragmentPocemonsListBinding? = null
    private val binding get() = _binding!!

    private val rvAdaptor = PocemonsListAdaptor { clickOnPocemon(it) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPocemonsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun clickOnPocemon(pocemon: Pocemon) {
        //переход на детали
    }
}