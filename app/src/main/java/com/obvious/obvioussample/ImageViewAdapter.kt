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
        return listImages?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var value=listImages?.get(position) ?: null;
        val requestOptions = RequestOptions()
        requestOptions.placeholder(android.R.drawable.ic_input_delete)
        requestOptions.override(800, 400)
        requestOptions.error(android.R.drawable.ic_input_delete)
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