package id.zelory.cekrek

import android.graphics.Bitmap
import android.graphics.Color
import java.io.File

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

data class CanvasConfig @JvmOverloads constructor(
    var width: CanvasSize = CanvasSize.WrapContent,
    var height: CanvasSize = CanvasSize.WrapContent,
    var color: Int = Color.WHITE
)

data class CekrekImageFileConfig @JvmOverloads constructor(
    val destination: File,
    var format: Bitmap.CompressFormat = destination.compressFormat(),
    var quality: Int = 100,
    var cekrekConfig: CekrekConfig = CekrekConfig()
)