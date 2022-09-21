package com.harsh.grocerylister.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.harsh.grocerylister.R
import com.harsh.grocerylister.database.GroceryItems

class GroceryRVAdapter(
    var List: List<GroceryItems>,
    private val groceryItemClickInterface: GroceryItemClickInterface
) : RecyclerView.Adapter<GroceryRVAdapter.GroceryViewHolder>() {

    inner class GroceryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTV = itemView.findViewById<TextView>(R.id.idTVItemName)
        val quantityTV = itemView.findViewById<TextView>(R.id.idTVQuantity)
        val priceTV = itemView.findViewById<TextView>(R.id.idTVPrice)
        val amountTV = itemView.findViewById<TextView>(R.id.idTVTotalCost)
        val deleteIV = itemView.findViewById<ImageView>(R.id.idIVDelete)
    }

    interface GroceryItemClickInterface {

        fun onItemClick(groceryItems: GroceryItems)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.grocery_rv_item, parent, false)
        return GroceryViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {
        holder.nameTV.text = List.get(position).itemName
        holder.quantityTV.text = List.get(position).itemQuantity.toString()
        holder.priceTV.text = "Rs. " + List.get(position).itemPrice.toString()
        val itemTotal: Int = List.get(position).itemPrice * List.get(position).itemQuantity
        holder.amountTV.text = "Rs. " + itemTotal.toString()
        holder.deleteIV.setOnClickListener {
            groceryItemClickInterface.onItemClick(List.get(position))
        }
    }

    override fun getItemCount(): Int {
        return List.size
    }
}