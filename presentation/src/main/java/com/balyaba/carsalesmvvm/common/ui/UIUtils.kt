package com.balyaba.carsalesmvvm.common.ui

import android.content.Context
import android.graphics.Point
import android.view.WindowManager

object UIUtils {
    fun getDisplaySize(context: Context): Pair<Int, Int> {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val size = Point()
        windowManager.defaultDisplay.getSize(size)
        return size.x to size.y
    }
}