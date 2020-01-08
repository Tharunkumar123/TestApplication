package com.example.testapplication

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.myapplication.MyApplication

class AdapterClass(private val modelClass: ArrayList<ModelClass> = ArrayList()) :
    RecyclerView.Adapter<AdapterClass.BaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view = LayoutInflater.from(MyApplication.getApplicationContext())
            .inflate(R.layout.recyclerview_item, parent, false)
        return BaseViewHolder(view)
    }

    override fun getItemCount(): Int {
        return modelClass.size
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {


        when (modelClass[position].selected) {
            0 -> {
                holder.constraintLayout.setBackgroundResource(R.drawable.cardbackground_0)
            }
            1 -> {
                holder.constraintLayout.setBackgroundResource(R.drawable.cardbackground_1)
            }
            2 -> {
                holder.constraintLayout.setBackgroundResource(R.drawable.cardbackground_2)
            }
        }
        holder.card.setOnClickListener {
            changeBg(position,0)
        }

        holder.blueButton.setOnClickListener {
            changeBg(position,1)
        }
        holder.greenButton.setOnClickListener {
            changeBg(position,2)
        }




    }

    private fun changeBg(position: Int, selected: Int) {4
        val myModel = modelClass[position]
        if (myModel.selected != selected) {
            myModel.selected = selected
            notifyItemChanged(position)
        }
    }

    class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val greenButton: Button = itemView.findViewById(R.id.buttonGreen)
        val blueButton: Button = itemView.findViewById(R.id.buttonBlue)
        val card: CardView = itemView.findViewById(R.id.cardItem)
        val constraintLayout: ConstraintLayout = itemView.findViewById(R.id.constraintLayout)
    }
}