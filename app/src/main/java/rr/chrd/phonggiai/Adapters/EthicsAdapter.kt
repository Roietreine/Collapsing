package rr.chrd.phonggiai.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rr.chrd.phonggiai.Models.EthicsModel
import rr.chrd.phonggiai.databinding.EthicsviewBinding

class EthicsAdapter: RecyclerView.Adapter<EthicsAdapter.AdapterHolder>() {

    private var listNiEthics = emptyList<EthicsModel>()

    class AdapterHolder (val adpts : EthicsviewBinding) :RecyclerView.ViewHolder (adpts.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHolder = AdapterHolder (
        EthicsviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            )

    override fun onBindViewHolder(holder: AdapterHolder, position: Int) {
        with (holder){
            with (listNiEthics[position]){

                adpts.ethicsDesc.text = this.ethicsD
            }
        }
    }

    override fun getItemCount(): Int {
      return  listNiEthics.size
    }

    fun setAdapter (setAdapt : List<EthicsModel> ){

        this.listNiEthics = setAdapt
    }
}