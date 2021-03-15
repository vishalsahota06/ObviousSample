package com.obvious.obvioussample

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.obvious.obvioussample.databinding.ImageDetailsScreenLayoutBinding
import kotlinx.android.synthetic.main.activity_main.*

class ImageDetailScreen : AppCompatActivity() {
    private var imageData: Image? = null
    private var toolbar: Toolbar? = null

    //    private lateinit var imageView: ImageView
    lateinit var binding: ImageDetailsScreenLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.image_details_screen_layout)
//        setContentView(R.layout.image_details_screen_layout)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val requestOptions = RequestOptions()
//        requestOptions.placeholder(R.drawable.place_holder1)
        requestOptions.override(800,480)
        requestOptions.error(android.R.drawable.stat_notify_error)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if (intent.hasExtra("imageData")!!) {
            imageData = intent.getParcelableExtra<Image>("imageData")
            Glide.with(this)
                .setDefaultRequestOptions(requestOptions)
                .load(imageData?.hdurl)
                .into(binding.imageDesc)
            binding.imageData = imageData
        } else {
            imageData = Image("", "", "", "", "", "", "", "")
            Glide.with(this)
                .setDefaultRequestOptions(requestOptions)
                .load(R.drawable.place_holder)
                .into(binding.imageDesc)
            binding.imageData = imageData
        }


//        imageView = findViewById<ImageView>(R.id.imageDesc)

    }
}
