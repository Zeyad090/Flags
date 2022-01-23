package com.example.flag
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.flag.databinding.FragmentOverviewBinding



class OverviewFragment : Fragment() {
    private val flagViewModel: FlagViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentOverviewBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.flagViewModel = flagViewModel
        binding.recyclerView.adapter = FlagAdapter()
        return binding.root

    }
}


