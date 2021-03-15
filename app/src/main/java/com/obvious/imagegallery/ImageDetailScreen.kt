package com.obvious.imagegallery

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_main.*

class ImageDetailScreen : AppCompatActivity() {
    private var imageData:Image ? =null
    private var toolbar: Toolbar?=null
    private lateinit var imageView:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.image_details_screen_layout)
        imageData= intent.getParcelableExtra<Image>("imageData")!!

        toolbar =findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val requestOptions = RequestOptions()
        requestOptions.placeholder(android.R.drawable.ic_input_delete)
        requestOptions.error(android.R.drawable.ic_input_delete)
imageView=findViewById<ImageView>(R.id.imageDesc)
        Glide.with(this)
            .setDefaultRequestOptions(requestOptions)
            .load(imageData?.hdurl)
            .into(imageView)
    }
}
