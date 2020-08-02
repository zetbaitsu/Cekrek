package id.zelory.cekrek.config

import android.view.View

/**
 * Created on : August 02, 2020
 * Author     : zetbaitsu
 * Name       : Zetra
 * GitHub     : https://github.com/zetbaitsu
 */
sealed class CanvasSize(val specSize: Int) {
    object WrapContent :
        CanvasSize(View.MeasureSpec.makeMeasureSpec((1 shl 30) - 1, View.MeasureSpec.AT_MOST))

    data class Specific(private val size: Int) :
        CanvasSize(View.MeasureSpec.makeMeasureSpec(size, View.MeasureSpec.EXACTLY))
}