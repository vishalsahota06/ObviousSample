package com.obvious.imagegallery

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    val context by lazy { application }
    var imagesLiveData : MutableLiveData<List<Image>> ?=null

    init {
        imagesLiveData= MutableLiveData()
    }

    fun readDataFromFile() {
        val jsonString: String
        jsonString = context.assets.open("data.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val listImages=object  : TypeToken<List<Image>>() {}.type
        var images: List<Image> = gson.fromJson(jsonString, listImages)
        imagesLiveData?.postValue(images)
    }
}