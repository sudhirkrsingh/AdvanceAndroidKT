package com.mega.kotlinapp.postAPIKotlin.mvvvm.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.mega.kotlinapp.R
import com.mega.kotlinapp.databinding.GiftcardBinding
import com.mega.kotlinapp.postAPIKotlin.mvvvm.model.GiftCardResponseList
import com.squareup.picasso.Picasso

class CardAdapter() : RecyclerView.Adapter<CardAdapter.GiftCardViewHolder>() {


    var list: List<GiftCardResponseList>? = null
    lateinit var context: Context

    fun setMovieList(movies: List<GiftCardResponseList>) {
        this.list= movies.toMutableList()
        notifyDataSetChanged()
    }

    constructor(context: Context, list: List<GiftCardResponseList>?) : this() {
        this.list = list
        this.context=context
        notifyDataSetChanged()

    }
    class GiftCardViewHolder(binding: GiftcardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var market_content_one: TextView = binding.marketContentOne
        var gift_card_name: TextView = binding.giftCardName
        var marketing_content_two: TextView = binding.marketingContentTwo
        var gift_card_img_url: ImageView = binding.giftCardImgUrl

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GiftCardViewHolder {

        val binding = GiftcardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GiftCardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GiftCardViewHolder, position: Int) {
        val giftCard: GiftCardResponseList = list!![position]

        holder.gift_card_name.text=giftCard.giftCardName
        holder.market_content_one.text=giftCard.marketingContent01
        holder.marketing_content_two.text=giftCard.marketingContent02
        Picasso.get().load(giftCard.giftCardImageUrl).into(holder.gift_card_img_url)
        holder.itemView.setOnClickListener(View.OnClickListener {


            val activity=it.context as AppCompatActivity
            activity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.layout_1,EditTextRoomFragment())
                .commitNow()
        })

    }

    override fun getItemCount(): Int {
        return list!!.size
    }

}