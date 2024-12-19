package com.jordel.menupractica

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.jordel.menupractica.databinding.FragmentBegudesBinding

class BegudesFragment : Fragment() {
    private val viewModel: MenuVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentBegudesBinding.inflate(inflater)

        viewModel.menu.observe(viewLifecycleOwner, Observer { menu ->
            binding.PreuBegudaTextView.text = menu.precioVeguda.toString()
            binding.NomBegudaTextView.text = menu.beguda
        })

        binding.buttonGoResum.setOnClickListener {
            if (binding.CantiatBegudesEditTextNumber.text.toString().isEmpty() || binding.CantiatBegudesEditTextNumber.text.toString().toInt() == 0) {
                Toast.makeText(requireContext(), "Introdueix el nombre de begudes", Toast.LENGTH_SHORT).show()
            }else{
                viewModel.updateMenuBeguda(binding.CantiatBegudesEditTextNumber.text.toString().toInt())
                findNavController().navigate(R.id.action_begudesFragment_to_totalFragment, null)
            }
        }

        return binding.root
    }

}