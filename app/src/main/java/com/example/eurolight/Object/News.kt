package com.example.eurolight.Object

import android.media.Image
import androidx.annotation.DrawableRes

data class News (
        @DrawableRes
        var image: Int?,
        var content: String
)