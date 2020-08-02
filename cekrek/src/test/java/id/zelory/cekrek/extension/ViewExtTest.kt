package id.zelory.cekrek.extension

import android.view.View
import id.zelory.cekrek.Cekrek
import id.zelory.cekrek.config.CanvasConfig
import id.zelory.cekrek.config.CanvasSize
import id.zelory.cekrek.config.CekrekConfig
import id.zelory.cekrek.config.CekrekImageFileConfig
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
class ViewExtTest {

    @Test
    fun `cekrek to bitmap without config should invoke Cekrek singleton`() {
        // Given
        val view = mockk<View>()

        // When
        view.cekrekToBitmap()

        // Then
        verify { Cekrek.toBitmap(view, any<CekrekConfig>()) }
    }

    @Test
    fun `cekrek to bitmap with config should invoke Cekrek singleton`() {
        // Given
        val view = mockk<View>()
        val cekrekConfig = CekrekConfig()

        // When
        view.cekrekToBitmap(cekrekConfig)

        // Then
        verify { Cekrek.toBitmap(view, cekrekConfig) }
    }

    @Test
    fun `cekrek to bitmap with config patch should invoke Cekrek singleton`() {
        // Given
        val view = mockk<View>()

        // When
        view.cekrekToBitmap {
            canvasConfig = CanvasConfig().apply {
                width = CanvasSize.Specific(1280)
            }
        }

        // Then
        verify {
            Cekrek.toBitmap(view, CekrekConfig().apply {
                canvasConfig = CanvasConfig().apply {
                    width = CanvasSize.Specific(1280)
                }
            })
        }
    }

    @Test
    fun `cekrek to image file with config should invoke Cekrek singleton`() {
        // Given
        val view = mockk<View>()
        val destination = File("image.jpg")
        val cekrekImageFileConfig = CekrekImageFileConfig(destination)

        // When
        view.cekrekToImageFile(cekrekImageFileConfig)

        // Then
        verify {
            Cekrek.toImageFile(
                view,
                cekrekImageFileConfig
            )
        }
    }

    @Test
    fun `cekrek to image file without config should invoke Cekrek singleton`() {
        // Given
        val view = mockk<View>()
        val destination = File("image.jpg")

        // When
        view.cekrekToImageFile(destination)

        // Then
        verify {
            Cekrek.toImageFile(
                view,
                CekrekImageFileConfig(destination)
            )
        }
    }

    @Test
    fun `cekrek to image file with config patch should invoke Cekrek singleton`() {
        // Given
        val view = mockk<View>()
        val destination = File("image.jpg")

        // When
        view.cekrekToImageFile(destination) {
            cekrekConfig.canvasConfig.width = CanvasSize.Specific(1280)
        }

        // Then
        verify {
            Cekrek.toImageFile(
                view,
                CekrekImageFileConfig(destination).apply {
                    cekrekConfig.canvasConfig.width = CanvasSize.Specific(1280)
                })
        }
    }

    companion object {
        @JvmStatic
        @BeforeClass
        fun setupClass() {
            mockkObject(Cekrek)
            every {
                Cekrek.toBitmap(
                    any(),
                    any<CekrekConfig>()
                )
            } returns mockk()
            every {
                Cekrek.toImageFile(
                    any(),
                    any<CekrekImageFileConfig>()
                )
            } returns mockk()
        }

        @JvmStatic
        @AfterClass
        fun teardownClass() {
            unmockkAll()
        }
    }
}