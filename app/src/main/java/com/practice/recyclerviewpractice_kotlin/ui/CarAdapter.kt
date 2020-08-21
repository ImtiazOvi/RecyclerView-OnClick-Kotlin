package com.practice.recyclerviewpractice_kotlin.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.practice.recyclerviewpractice_kotlin.R
import com.practice.recyclerviewpractice_kotlin.data.Cars

class CarAdapter(var items: ArrayList<Cars>, var clickListner: OnCardItemClickListner): RecyclerView.Adapter<CarViewHolder>(){

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
       lateinit var carViewHolder: CarViewHolder
        carViewHolder = CarViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false))
        return carViewHolder
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.initialize(items.get(position), clickListner)
    }
}
class CarViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var carName = itemView.findViewById<TextView>(R.id.txt_name)
    var carDescription = itemView.findViewById<TextView>(R.id.txt_description)

    fun initialize(item: Cars, action: OnCardItemClickListner){
        carName.text = item.name
        carDescription.text = item.description
        itemView.setOnClickListener{
            action.onItemClick(item, adapterPosition)
        }
    }

}
interface OnCardItemClickListner{
    fun onItemClick(item: Cars, position: Int)
}
