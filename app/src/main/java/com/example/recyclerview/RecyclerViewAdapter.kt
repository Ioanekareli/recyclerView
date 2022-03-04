package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.Cardview2Binding
import com.example.recyclerview.databinding.CardviewBinding

class RecyclerViewAdapter(
    val onClick: () -> Unit,
    val context:Context,
    val items:List<ImageDataClass>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    companion object{
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_ONE){
            return ViewHolder(
                CardviewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }else{
            AnotherViewHolder(
                Cardview2Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val item = items.get(position)

        if(holder is ViewHolder){
            holder.tvItem.text = item.title
            holder.img.setOnClickListener {
                onClick.invoke()
            }
            holder.img.setImageResource(item.image)
        }
        else if (holder is AnotherViewHolder){
            holder.anotherTvItem.text = item.title
            holder.anotherImg.setOnClickListener {
                onClick.invoke()
            }
            holder.anotherImg.setImageResource(item.image)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].viewType
    }



    override fun getItemCount(): Int {
        return items.size
    }




    class ViewHolder(binding: CardviewBinding):RecyclerView.ViewHolder(binding.root){
        val tvItem = binding.titleTv
        val img = binding.imgView
    }

    class AnotherViewHolder(binding: Cardview2Binding):RecyclerView.ViewHolder(binding.root){
        val anotherTvItem = binding.titleTv2
        val anotherImg = binding.imgView2
    }


}