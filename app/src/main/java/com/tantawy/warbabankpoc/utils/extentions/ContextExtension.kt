package com.tantawy.warbabankpoc.utils.extentions

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.annotation.*
import androidx.core.content.res.ResourcesCompat

fun Context.getDrawableCompat(@DrawableRes drawableRes: Int): Drawable? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        ResourcesCompat.getDrawable(resources, drawableRes, theme)
    } else
        resources.getDrawable(drawableRes)
}