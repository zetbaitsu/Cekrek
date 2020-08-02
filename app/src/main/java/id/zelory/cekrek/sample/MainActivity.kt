package id.zelory.cekrek.sample

import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import id.zelory.cekrek.extension.cekrekToBitmap
import id.zelory.cekrek.extension.cekrekToImageFile
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {
    private lateinit var sampleView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sampleView = LayoutInflater.from(this).inflate(R.layout.sample_layout, null)

        toBitmapButton.setOnClickListener { cekrekToBitmap() }
        toImageFileButton.setOnClickListener { cekrekToImageFile() }
    }

    private fun cekrekToBitmap() {
        val bitmap = sampleView.cekrekToBitmap()

        Log.d(LOG_TAG, "Bitmap width: ${bitmap.width}")
        Log.d(LOG_TAG, "Bitmap height: ${bitmap.height}")

        imageView.setImageBitmap(bitmap)
    }

    private fun cekrekToImageFile() {
        val imageFile = getExternalFilesDir(Environment.DIRECTORY_PICTURES)?.let {
            val file = File("${it.absolutePath}${File.separator}cekrek.jpg")
            return@let sampleView.cekrekToImageFile(file).also {
                Log.d(LOG_TAG, "Cekrek image saved in $it")
            }
        }

        val bitmap = BitmapFactory.decodeFile(imageFile?.absolutePath)

        Log.d(LOG_TAG, "Bitmap width: ${bitmap.width}")
        Log.d(LOG_TAG, "Bitmap height: ${bitmap.height}")

        imageView.setImageBitmap(bitmap)
    }

    companion object {
        private const val LOG_TAG = "Cekrek"
    }
}