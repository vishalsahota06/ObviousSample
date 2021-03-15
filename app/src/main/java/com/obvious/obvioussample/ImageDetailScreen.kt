package com.obvious.obvioussample

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_main.*

class ImageDetailScreen : AppCompatActivity() {
    private lateinit var appViewPagerAdapter: AppViewPagerAdapter
    private lateinit var imageData: Image
    private var toolbar: Toolbar? = null
    private lateinit var listImages: ArrayList<Image>
    private lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.image_details_screen_layout)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        appViewPagerAdapter = AppViewPagerAdapter()
        viewPager2 = findViewById(R.id.viewpager)
        viewPager2.adapter = appViewPagerAdapter
        if (intent.hasExtra("imageData")!!) {
            imageData = intent.getParcelableExtra<Image>("imageData")!!
            listImages = intent.getBundleExtra("bundle")?.getParcelableArrayList("imageDataList")!!
            appViewPagerAdapter.loadData(listImages)
        }

        if (imageData != null) {
            listImages.forEachIndexed { idx, image ->
                run() {
                    if (image.equals(imageData)) {
                        viewPager2.post {
                            viewPager2.setCurrentItem(idx, true)
                        }

                    }
                }
            }
        }

    }
}
