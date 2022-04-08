package rr.chrd.phonggiai.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import rr.chrd.phonggiai.Adapters.RulesAdapter
import rr.chrd.phonggiai.R
import rr.chrd.phonggiai.ViewModelData
import rr.chrd.phonggiai.databinding.FragmentRulesBinding


class RulesFragment : Fragment() {

    private var _binding : FragmentRulesBinding? = null
    private val binders get() = _binding!!
    private var rulesData = ViewModelData()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentRulesBinding.inflate(inflater,container,false)
        val rootView = binders.root
        rulesData = ViewModelProvider(this)[ViewModelData::class.java]

        rulesData.rulesFun()
        val adpts = RulesAdapter()

        rulesData.rlsNf.observe(viewLifecycleOwner){

            if (it != null){

                adpts.setAdapter(it)
                binders.rulesRecycler.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager (context)
                    adapter = adpts

                }
            }
        }

        binders.bckButton.setOnClickListener { findNavController().navigate(R.id.action_rulesFragment_to_mainFragment) }

        return  rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}