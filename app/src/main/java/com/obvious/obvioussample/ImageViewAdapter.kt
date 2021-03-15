package com.obvious.obvioussample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.obvious.obvioussample.R


class ImageViewAdapter(val activityListener: MainActivityListener) : RecyclerView.Adapter<ImageViewAdapter.ViewHolder>() {
    private lateinit var view: View
    var listImages: List<Image>? = null
    lateinit var context: Context


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView:ImageView
        init{
            imageView=itemView.findViewById(R.id.imageDisp)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.getContext()
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_grid_item_1, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listImages?.size ?: 10
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var value=listImages?.get(position) ?: null;
        val requestOptions = RequestOptions()
        requestOptions.placeholder(R.drawable.place_holder2)
        requestOptions.override(400, 300)
        requestOptions.error(R.drawable.place_holder1)
        Glide.with(context)
            .setDefaultRequestOptions(requestOptions)
            .load(listImages?.get(position)?.url)
            .into(holder.imageView)
        holder.imageView.setOnClickListener {
            listImages?.get(position)?.let { it1 -> activityListener.onClickItem(it1) }
        }
    }

    fun setImages(it: List<Image>?) {
        listImages = it;
        notifyDataSetChanged()
    }
}