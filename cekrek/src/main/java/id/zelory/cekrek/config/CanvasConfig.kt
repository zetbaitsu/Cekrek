package id.zelory.cekrek.config

import android.graphics.Color

/**
 * Created on : August 02, 2020
 * Author     : zetbaitsu
 * Name       : Zetra
 * GitHub     : https://github.com/zetbaitsu
 */
data class CanvasConfig @JvmOverloads constructor(
    var width: CanvasSize = CanvasSize.WrapContent,
    var height: CanvasSize = CanvasSize.WrapContent,
    var color: Int = Color.WHITE
)