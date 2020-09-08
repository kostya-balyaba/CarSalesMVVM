package com.balyaba.carsalesmvvm.features.carslist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.balyaba.carsalesmvvm.R
import com.balyaba.entities.Car
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_car_list.view.*


class CarsListAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val carsList: MutableList<Car> = mutableListOf()

    fun addItems(newItemsList: List<Car>) {
        carsList.addAll(newItemsList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_car_list, parent, false)
        return CarViewHolder(view)
    }

    override fun getItemCount(): Int = carsList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CarViewHolder).bind(carsList[position])
    }

    inner class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(car: Car) {
            with(itemView) {
                titleView.text = car.name
                subTitleView.text = car.description

                if (car.photoUrl.isNullOrEmpty())
                    photoView.visibility = View.GONE
                else {
                    photoView.visibility = View.VISIBLE
                    Picasso.with(context)
                        .load(car.photoUrl)
                        .into(photoView)
                }
            }
        }
    }
}