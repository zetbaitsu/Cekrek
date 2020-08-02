package id.zelory.cekrek

import android.graphics.Bitmap
import android.graphics.Color
import android.view.View
import id.zelory.cekrek.config.CanvasSize
import id.zelory.cekrek.config.CekrekConfig
import id.zelory.cekrek.config.CekrekImageFileConfig
import id.zelory.cekrek.extension.saveToFile
import io.mockk.*
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import java.io.File

/**
 * Created on : August 02, 2020
 * Author     : zetbaitsu
 * Name       : Zetra
 * GitHub     : https://github.com/zetbaitsu
 */
class CekrekTest {

    @Test
    fun `cekrek to bitmap should create bitmap with default config`() {
        // Given
        val view = mockk<View>(relaxed = true)

        // When
        Cekrek.toBitmap(view)

        // Then
        verify { Cekrek.toBitmap(view, CekrekConfig()) }
    }

    @Test
    fun `cekrek to bitmap with config patch should create bitmap with patched config`() {
        // Given
        val view = mockk<View>(relaxed = true)

        // When
        Cekrek.toBitmap(view) {
            canvasConfig.width = CanvasSize.Specific(1280)
            canvasConfig.height = CanvasSize.Specific(1280)
            canvasConfig.color = Color.RED
            bitmapConfig = Bitmap.Config.ALPHA_8
        }

        // Then
        verify {
            Cekrek.toBitmap(view, CekrekConfig().apply {
                canvasConfig.width = CanvasSize.Specific(1280)
                canvasConfig.width = CanvasSize.Specific(1280)
                canvasConfig.height = CanvasSize.Specific(1280)
                canvasConfig.color = Color.RED
                bitmapConfig = Bitmap.Config.ALPHA_8
            })
        }
    }

    @Test
    fun `cekrek to image file with config should create bitmap with that config and save it`() {
        // Given
        val view = mockk<View>(relaxed = true)
        val destination = File("image.jpg")
        val config = CekrekImageFileConfig(destination).apply {
            cekrekConfig.canvasConfig.width = CanvasSize.Specific(1280)
        }

        // When
        Cekrek.toImageFile(view, config)

        // Then
        verify {
            Cekrek.toBitmap(view, config.cekrekConfig)
            any<Bitmap>().saveToFile(destination, config.format, config.quality)
        }
    }

    @Test
    fun `cekrek to image file should create bitmap with default config and save it`() {
        // Given
        val view = mockk<View>(relaxed = true)
        val destination = File("image.jpg")

        // When
        Cekrek.toImageFile(view, destination)

        // Then
        val config = CekrekImageFileConfig(destination)
        verify {
            Cekrek.toBitmap(view, config.cekrekConfig)
            any<Bitmap>().saveToFile(destination, config.format, config.quality)
        }
    }

    @Test
    fun `cekrek to image file with config patch should create bitmap with that config and save it`() {
        // Given
        val view = mockk<View>(relaxed = true)
        val destination = File("image.png")

        // When
        Cekrek.toImageFile(view, destination) {
            cekrekConfig = CekrekConfig()
            format = Bitmap.CompressFormat.PNG
            quality = 80
        }

        // Then
        val config = CekrekImageFileConfig(destination).apply {
            cekrekConfig = CekrekConfig()
            format = Bitmap.CompressFormat.PNG
            quality = 80
        }
        verify {
            Cekrek.toBitmap(view, config.cekrekConfig)
            any<Bitmap>().saveToFile(destination, config.format, config.quality)
        }
    }

    companion object {
        @JvmStatic
        @BeforeClass
        fun setupClass() {
            mockkObject(Cekrek)
            mockkStatic("id.zelory.cekrek.extension.BitmapExtKt")
            mockkStatic(Bitmap::class)
            every { Bitmap.createBitmap(any(), any(), any()) } returns mockk(relaxed = true)
        }

        @JvmStatic
        @AfterClass
        fun teardownClass() {
            unmockkAll()
        }
    }

}