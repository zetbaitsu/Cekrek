package id.zelory.cekrek

import android.graphics.Bitmap
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import java.io.File

/**
 * Created on : August 02, 2020
 * Author     : zetbaitsu
 * Name       : Zetra
 * GitHub     : https://github.com/zetbaitsu
 */
class BitmapExtTest {

    @Test
    fun `get compress format for png file should return PNG format`() {
        assertThat(File("image.png").compressFormat(), equalTo(Bitmap.CompressFormat.PNG))
    }

    @Test
    fun `get compress format for webp file should return WEBP format`() {
        assertThat(File("image.webp").compressFormat(), equalTo(Bitmap.CompressFormat.WEBP))
    }

    @Test
    fun `get compress format for jpg file should return JPEG format`() {
        assertThat(File("image.jpg").compressFormat(), equalTo(Bitmap.CompressFormat.JPEG))
    }

    @Test
    fun `get compress format for jpeg file should return JPEG format`() {
        assertThat(File("image.jpeg").compressFormat(), equalTo(Bitmap.CompressFormat.JPEG))
    }
}