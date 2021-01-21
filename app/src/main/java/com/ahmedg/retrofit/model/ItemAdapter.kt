package com.ahmedg.retrofit.model

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.ahmedg.retrofit.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.gridview.view.*

class ItemAdapter(var dataList: List<Result>) : BaseAdapter() {
    override fun getCount(): Int {
        return dataList.size
    }

    override fun getItem(position: Int): Any {
        return dataList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ServiceCast")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val data = this.dataList[position]
        var inflator = parent?.context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var dataView: View = inflator.inflate(R.layout.gridview, parent, false)

        var image: ImageView = dataView.imageView
        var txt: TextView = dataView.txtMovies
        txt.text = data.original_title
        Glide.with(dataView).load("http://image.tmdb.org/t/p/w500${data.backdrop_path}")
            .into(image)


        return dataView
    }


}





















