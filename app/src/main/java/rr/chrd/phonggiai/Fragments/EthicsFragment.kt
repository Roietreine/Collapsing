package rr.chrd.phonggiai.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dakulangsakalam.customwebview.presentation.utils.writeLogs
import rr.chrd.phonggiai.Adapters.EthicsAdapter
import rr.chrd.phonggiai.R
import rr.chrd.phonggiai.ViewModelData
import rr.chrd.phonggiai.databinding.FragmentEthicsBinding


class EthicsFragment : Fragment() {


    private var _binding : FragmentEthicsBinding? = null
    private val binders get() = _binding!!
    private var ethicsData = ViewModelData()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentEthicsBinding.inflate(inflater,container,false)
        val rootView = binders.root
        ethicsData = ViewModelProvider (this) [ViewModelData::class.java]

        ethicsData.ethicsFun()
        val adpts = EthicsAdapter()
        ethicsData.thcsNf.observe(viewLifecycleOwner){
            if (it != null){
                adpts.setAdapter(it)
                binders.ethicsRecycler.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager (context)
                    adapter = adpts
                }
            }
        }

        binders.bckButton.setOnClickListener { findNavController().navigate(R.id.action_ethicsFragment_to_mainFragment) }

        return rootView
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}