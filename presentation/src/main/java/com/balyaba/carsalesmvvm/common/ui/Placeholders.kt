package com.balyaba.carsalesmvvm.common.ui

import android.graphics.drawable.Drawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import androidx.annotation.ColorInt


object Placeholders {

    private val placeholdersCache = hashMapOf<String, Drawable>()

    fun getPlaceholder(width: Int, height: Int, @ColorInt color: Int): Drawable {
        val key = makeKey(width, height, color)
        return when {
            placeholdersCache.containsKey(key) -> requireNotNull(placeholdersCache[key])
            else -> {
                val drawable = makeRect(width, height, color)
                placeholdersCache[key] = drawable
                drawable
            }
        }
    }

    private fun makeKey(width: Int, height: Int, @ColorInt color: Int): String =
        "$width-$height-$color"

    private fun makeRect(w: Int, h: Int, @ColorInt color: Int): Drawable {
        val rect = ShapeDrawable(RectShape())
        rect.intrinsicHeight = h
        rect.intrinsicWidth = w
        rect.paint.isAntiAlias = true
        rect.paint.color = color
        return rect
    }
}