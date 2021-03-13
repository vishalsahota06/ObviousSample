package com.obvious.imagegallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

public class MainActivity : AppCompatActivity() {
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
        gridAdapter = ImageViewAdapter()
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
}

private const val TAG = "MainActivity"

