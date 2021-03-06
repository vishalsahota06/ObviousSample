package com.obvious.imagegallery

import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Image (
val copyright:String,
val date:String,
val explanation:String,
val hdurl:String,
val media_type:String,
val service_version:String,
val title:String,
val url:String
) : Parcelable