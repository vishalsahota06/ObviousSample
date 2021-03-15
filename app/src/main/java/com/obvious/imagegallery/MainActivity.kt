package com.obvious.imagegallery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.image_grid_item_1.*

public class MainActivity : AppCompatActivity(), MainActivityListener {
    private var toolbar: Toolbar?=null
    private lateinit var activityViewModel: MainActivityViewModel
    val recyclerView by lazy { findViewById<RecyclerView>(R.id.gridView) }
    var gridAdapter: ImageViewAdapter ?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar =findViewById(R.id.toolbar)
        toolbar?.title="Obvious"
        setSupportActionBar(toolbar)
        activityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        activityViewModel.readDataFromFile()
        activityViewModel.imagesLiveData?.observe(this, imageListObserver)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        gridAdapter = ImageViewAdapter(this)
        recyclerView?.apply {
            this.layoutManager =
                GridLayoutManager(this@MainActivity, 3, RecyclerView.VERTICAL, false)
            this.adapter = gridAdapter
        }
    }

    val imageListObserver = Observer<List<Image>> {
        gridAdapter?.setImages(it)
        it.forEachIndexed { idx, image -> Log.i(TAG, "> Item $idx:\n$image") }

    }

    override fun onClickItem(image: Image) {
        var intent= Intent(this,ImageDetailScreen::class.java)
        intent.putExtra("imageData",image)
        startActivity(intent)
    }
}

private const val TAG = "MainActivity"

