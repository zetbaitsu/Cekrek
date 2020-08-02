package id.zelory.cekrek.config

import android.graphics.Bitmap

/**
 * Created on : August 02, 2020
 * Author     : zetbaitsu
 * Name       : Zetra
 * GitHub     : https://github.com/zetbaitsu
 */
data class CekrekConfig @JvmOverloads constructor(
    var canvasConfig: CanvasConfig = CanvasConfig(),
    var bitmapConfig: Bitmap.Config = Bitmap.Config.ARGB_8888
)