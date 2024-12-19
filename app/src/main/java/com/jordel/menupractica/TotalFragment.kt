package com.jordel.menupractica

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.jordel.menupractica.databinding.FragmentTotalBinding

class TotalFragment : Fragment() {
    private val viewModel: MenuVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentTotalBinding.inflate(inflater)
        viewModel.menu.observe(viewLifecycleOwner, Observer { menu ->
            val sumaPlats = menu.cantitatPlats * menu.precioPlat
            val sumaVegudes = menu.cantitatVegudes * menu.precioVeguda
            val sumaTotal = sumaPlats + sumaVegudes
            binding.textViewPreuPlat.text = sumaPlats.toString()
            binding.textViewPreuBeguda.text = sumaVegudes.toString()
            binding.textView6.text = sumaTotal.toString()
        })

        // Inflate the layout for this fragment
        return binding.root
    }
}