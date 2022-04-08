package rr.chrd.phonggiai.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import rr.chrd.phonggiai.R
import rr.chrd.phonggiai.databinding.FragmentMainBinding

class MainFragment : Fragment(), View.OnClickListener {


    private var _binding : FragmentMainBinding? = null
    private val binders get() = _binding!!

    private  val dataImg = intArrayOf(
        R.drawable.banner1,
        R.drawable.banner2,
        R.drawable.banner3
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentMainBinding.inflate(inflater,container,false)
        val rootView = binders.root


        binders.carobanner.pageCount = dataImg.size
        binders.carobanner.setImageListener { position, imageView ->
            imageView.scaleType = ImageView.ScaleType.FIT_XY
            imageView.setImageResource(dataImg[position])
        }

        binders.historyCard.setOnClickListener(this)
        binders.ethicsCard.setOnClickListener(this)
        binders.rulesCard.setOnClickListener(this)
        binders.tipsCard.setOnClickListener(this)
        return rootView

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        when (v){
            binders.historyCard -> findNavController().navigate(R.id.action_mainFragment_to_homeFragment)
            binders.ethicsCard -> findNavController().navigate(R.id.action_mainFragment_to_ethicsFragment)
            binders.rulesCard -> findNavController().navigate(R.id.action_mainFragment_to_rulesFragment)
            binders.tipsCard -> findNavController().navigate(R.id.action_mainFragment_to_tipsFragment)
        }
    }

}