package id.zelory.cekrek.config

import android.graphics.Bitmap
import id.zelory.cekrek.extension.compressFormat
import java.io.File

/**
 * Created on : August 02, 2020
 * Author     : zetbaitsu
 * Name       : Zetra
 * GitHub     : https://github.com/zetbaitsu
 */
data class CekrekImageFileConfig @JvmOverloads constructor(
    val destination: File,
    var format: Bitmap.CompressFormat = destination.compressFormat(),
    var quality: Int = 100,
    var cekrekConfig: CekrekConfig = CekrekConfig()
)