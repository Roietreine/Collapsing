package rr.chrd.phonggiai.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import rr.chrd.phonggiai.R
import rr.chrd.phonggiai.ViewModelData
import rr.chrd.phonggiai.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {


    private var _binding : FragmentHomeBinding? = null
    private val  binders get() = _binding!!
    private  var homeData = ViewModelData()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        val rootView = binders.root
        homeData = ViewModelProvider (this) [ViewModelData::class.java]


        homeDetails()

        binders.backButton.setOnClickListener {findNavController().navigate(R.id.action_homeFragment_to_mainFragment)}

        
        return rootView
    }



    private fun homeDetails(){

        homeData.bTitle.observe(viewLifecycleOwner,binders.homeTitle::setText)
        homeData.bDesc.observe(viewLifecycleOwner,binders.homeDesc::setText)
        homeData.wTitle.observe(viewLifecycleOwner,binders.homeTitle1::setText)
        homeData.wDesc.observe(viewLifecycleOwner,binders.homeDesc1::setText)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}