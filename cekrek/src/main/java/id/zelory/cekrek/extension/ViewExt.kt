package id.zelory.cekrek.extension

import android.graphics.Bitmap
import android.view.View
import id.zelory.cekrek.Cekrek
import id.zelory.cekrek.config.CekrekConfig
import id.zelory.cekrek.config.CekrekImageFileConfig
import java.io.File

/**
 * Created on : August 02, 2020
 * Author     : zetbaitsu
 * Name       : Zetra
 * GitHub     : https://github.com/zetbaitsu
 */
fun View.cekrekToBitmap(config: CekrekConfig): Bitmap {
    return Cekrek.toBitmap(this, config)
}

@JvmOverloads
fun View.cekrekToBitmap(configPatch: CekrekConfig.() -> Unit = {}): Bitmap {
    return cekrekToBitmap(CekrekConfig().apply(configPatch))
}

fun View.cekrekToImageFile(config: CekrekImageFileConfig): File {
    return Cekrek.toImageFile(this, config)
}

@JvmOverloads
fun View.cekrekToImageFile(
    destination: File,
    configPatch: CekrekImageFileConfig.() -> Unit = {}
): File {
    return cekrekToImageFile(CekrekImageFileConfig(destination).apply(configPatch))
}