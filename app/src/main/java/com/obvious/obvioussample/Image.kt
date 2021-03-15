package com.obvious.obvioussample

import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Image(
    val copyright: String?,
    val date: String?,
    val explanation: String?,
    val hdurl: String?,
    val media_type: String?,
    val service_version: String?,
    val title: String?,
    val url: String?
) : Parcelable {
    override fun equals(other: Any?): Boolean {
        var it = other as Image
        if (this.title.equals(it?.title) && this.url.equals(it?.url) && this.hdurl.equals(it?.hdurl) && this.copyright.equals(
                it?.copyright
            )
        )
            return true
        else return false
    }
}