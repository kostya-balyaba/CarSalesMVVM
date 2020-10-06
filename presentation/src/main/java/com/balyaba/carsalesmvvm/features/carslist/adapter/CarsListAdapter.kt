package com.balyaba.carsalesmvvm.features.carslist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.balyaba.carsalesmvvm.R
import com.balyaba.carsalesmvvm.common.ui.Placeholders
import com.balyaba.carsalesmvvm.common.ui.UIUtils
import com.balyaba.entities.Car
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kotlinx.android.synthetic.main.item_car_list.view.*


class CarsListAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val carsList: MutableList<Car> = mutableListOf()
    private var placeholderWidth: Int = 0
    private var placeholderHeight: Int = 0
    var listener: OnItemClickListener? = null

    init {
        placeholderWidth = UIUtils.getDisplaySize(context).first
        placeholderHeight = placeholderWidth / 2
    }

    fun replaceItems(newItemsList: List<Car>) {
        carsList.clear()
        carsList.addAll(newItemsList)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_car_list, parent, false)
        return CarViewHolder(view)
    }

    override fun getItemCount(): Int = carsList.size

    override fun getItemId(position: Int): Long = position.toLong()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CarViewHolder).bind(carsList[position])
    }

    inner class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener { listener?.carItemClicked(carsList[adapterPosition]) }
        }

        fun bind(car: Car) {
            with(itemView) {
                titleView.text = car.name
                subTitleView.text = car.description

                val placeholderColor = getColor(context, android.R.color.white)
                val placeholder = Placeholders.getPlaceholder(placeholderWidth, placeholderHeight, placeholderColor)

                Glide.with(context)
                    .load(car.photoUrl)
                    .placeholder(placeholder)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(photoView)
            }
        }
    }

    interface OnItemClickListener {
        fun carItemClicked(car: Car)
    }
}
