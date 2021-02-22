package com.example.listview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
         var itemName:TextView
         var qty:TextView
         var note : TextView

        init {
            itemName = itemView.findViewById(R.id.tvItemName)
            qty = itemView.findViewById(R.id.tvQuantity)
            note = itemView.findViewById(R.id.tvNote)

            itemView.setOnClickListener{
                var position:Int = adapterPosition
                val context = itemView.context
                val intent = Intent(context,FragmentTwo::class.java).apply {
                    putExtra("NUMBER",position)
                    putExtra("CODE", itemName.text)
                    putExtra("CATEGORY",qty.text)
                    putExtra("CONTENT", note.text)
                }
                context.startActivity(intent)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.card_view,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemName.text = ItemList[position].itemName
        holder.qty.text = ItemList[position].qty.toString()
        holder.note.text = ItemList[position].note
    }

    override fun getItemCount(): Int = ItemList.size

}