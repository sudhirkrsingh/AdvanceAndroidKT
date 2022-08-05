package com.mega.kotlinapp.postAPIKotlin.postapimvp.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.mega.kotlinapp.databinding.SinglemallBinding
import com.mega.kotlinapp.postAPIKotlin.postapimvp.model.Stores
import com.mega.kotlinapp.postAPIKotlin.postapimvp.presenter.Communicator
import com.squareup.picasso.Picasso

class StoreAdapter() : RecyclerView.Adapter<StoreAdapter.StoreViewHolder>() {
    var list: List<Stores>? = null
    lateinit var communicator: Communicator
    lateinit var context:Context

    constructor(context: Context, list: List<Stores>?) : this() {
        this.list = list
        this.context=context
    }


    class StoreViewHolder(binding: SinglemallBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var brandName: TextView = binding.brandName
        var brandLoc: TextView = binding.brandLoc
        var brandImg: ImageView = binding.brandImg

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        val binding = SinglemallBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StoreViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        val stores: Stores = list!![position]
        holder.brandName.text = stores.brandName
        holder.brandLoc.text = stores.storeAddress

        if (stores.storeImages.isNotEmpty()) {
            Picasso.get().load(stores.storeImages[0]).into(holder.brandImg)
        } else {
            Picasso.get().load(stores.storeImageUrl).into(holder.brandImg)
        }
        holder.itemView.setOnClickListener(View.OnClickListener {

            val activity=it.context as AppCompatActivity

            communicator =activity as
                    Communicator

            communicator.PassData(stores.brandName!!)

        })

    }

    override fun getItemCount(): Int {
        return list!!.size
    }


}