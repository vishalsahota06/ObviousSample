package com.obvious.obvioussample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.obvious.obvioussample.databinding.ViewPagerItemBinding

class AppViewPagerAdapter : RecyclerView.Adapter<AppViewPagerAdapter.ViewHolder>() {
    private lateinit var binding: ViewPagerItemBinding
    private var listImages: ArrayList<Image> = ArrayList()
    private lateinit var context: Context
    private lateinit var imageData:Image

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.view_pager_item,
            parent,
            false
        )
        return ViewHolder(binding.root);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        binding.imageData = listImages.get(position)
        val requestOptions = RequestOptions()
//        requestOptions.placeholder(R.drawable.place_holder1)
//        requestOptions.override(800, 480)
        requestOptions.error(android.R.drawable.stat_notify_error)
        Glide.with(context)
            .setDefaultRequestOptions(requestOptions)
            .load(listImages.get(position).hdurl)
            .into(binding.imageDesc)
    }

    override fun getItemCount(): Int {
        if (listImages == null) return 0 else return listImages.size
    }

    fun loadData(listImages: List<Image>?) {
        this.listImages = listImages as ArrayList<Image>
        notifyDataSetChanged()
    }

}
