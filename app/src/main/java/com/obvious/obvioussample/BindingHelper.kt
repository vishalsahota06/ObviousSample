package com.obvious.obvioussample

class BindingHelper {
companion object{
    @JvmStatic
    fun getCopyRight(imageData:Image) : String{
        return if (imageData.copyright!=null)  imageData.copyright else ""
    }
}
}