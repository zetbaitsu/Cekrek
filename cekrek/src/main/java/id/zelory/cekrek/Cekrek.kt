package id.zelory.cekrek

import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View
import java.io.File

/**
 * Created on : August 02, 2020
 * Author     : zetbaitsu
 * Name       : Zetra
 * GitHub     : https://github.com/zetbaitsu
 */
object Cekrek {

    fun toBitmap(view: View, config: CekrekConfig): Bitmap {
        view.measure(config.canvasConfig.width.specSize, config.canvasConfig.height.specSize)
        return Bitmap.createBitmap(view.measuredWidth, view.measuredHeight, config.bitmapConfig)
            .also {
                val canvas = Canvas(it)
                canvas.drawColor(config.canvasConfig.color)
                view.layout(0, 0, view.measuredWidth, view.measuredHeight)
                view.draw(canvas)
            }
    }

    @JvmOverloads
    fun toBitmap(view: View, configPatch: CekrekConfig.() -> Unit = {}): Bitmap {
        return toBitmap(view, CekrekConfig().apply(configPatch))
    }

    fun toImageFile(view: View, config: CekrekImageFileConfig): File {
        return toBitmap(view, config.cekrekConfig).saveToFile(
            config.destination,
            config.format,
            config.quality
        )
    }

    @JvmOverloads
    fun toImageFile(
        view: View,
        destination: File,
        configPatch: CekrekImageFileConfig.() -> Unit = {}
    ): File {
        return toImageFile(view, CekrekImageFileConfig(destination).apply(configPatch))
    }
}