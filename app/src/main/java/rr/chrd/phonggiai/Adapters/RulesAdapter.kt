package rr.chrd.phonggiai.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rr.chrd.phonggiai.Models.RulesModel
import rr.chrd.phonggiai.databinding.RulesviewBinding

class RulesAdapter : RecyclerView.Adapter<RulesAdapter.AdapterHolder>() {
    class AdapterHolder (val adpts : RulesviewBinding) : RecyclerView.ViewHolder(adpts.root)

    private var listNiRules = emptyList<RulesModel>()

    fun setAdapter (setAdapt : List<RulesModel>){
        this.listNiRules = setAdapt
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RulesAdapter.AdapterHolder = AdapterHolder(

        RulesviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun onBindViewHolder(holder: RulesAdapter.AdapterHolder, position: Int) {

        with (holder){
            with (listNiRules[position]){

                adpts.rulesDesc.text = this.rulesD
            }
        }
    }
    override fun getItemCount(): Int {
      return listNiRules.size
    }
}