package com.example.crystallball

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.crystallball.databinding.FragmentPredictBinding

class PredictFragment : Fragment() {

    private lateinit var binding: FragmentPredictBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPredictBinding.inflate(inflater, container,false)
        return binding.root
    }
}