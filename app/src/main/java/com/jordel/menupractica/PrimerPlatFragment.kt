package com.jordel.menupractica

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.jordel.menupractica.databinding.FragmentPrimerPlatBinding

class PrimerPlatFragment : Fragment() {
    private val viewModel: MenuVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPrimerPlatBinding.inflate(inflater, container, false)
        viewModel.menu.observe(viewLifecycleOwner, Observer { menu ->
            binding.PreuPlatTextView.text = menu.precioPlat.toString()
            binding.NomPlatTextView.text = menu.plat
        })

        binding.buttonGoBegudes.setOnClickListener {
            if (binding.CantiatPlatsEditTextNumber.text.toString().isEmpty() || binding.CantiatPlatsEditTextNumber.text.toString().toInt() == 0) {
                Toast.makeText(requireContext(), "Introdueix el nombre de plats", Toast.LENGTH_SHORT).show()
            }else{
                viewModel.updateMenuPrimerPlat(binding.CantiatPlatsEditTextNumber.text.toString().toInt())
                findNavController().navigate(R.id.action_primerPlatFragment_to_begudesFragment, null)
            }
        }

        return binding.root
    }
}
