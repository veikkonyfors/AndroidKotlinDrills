package fi.viware.takephoto

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.lifecycle.lifecycleScope
import com.google.android.material.button.MaterialButton
import java.io.File
import java.util.*

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private var imageUri: Uri? = null
    private val previewImage by lazy { findViewById<ImageView>(R.id.image_preview) }

    private val takeImageResult =
        registerForActivityResult(ActivityResultContracts.TakePicture()) { isSuccess ->
            if (isSuccess) {
                imageUri?.let { uri ->
                    previewImage.setImageURI(uri)
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<MaterialButton>(R.id.take_photo_button).setOnClickListener {
            lifecycleScope.launchWhenStarted {
                val tmpFile = File.createTempFile("tmp_image_file", ".png", cacheDir).apply {
                    createNewFile()
                    deleteOnExit()
                }
                imageUri=
                    FileProvider.getUriForFile(
                        Objects.requireNonNull(getApplicationContext()),
                        BuildConfig.APPLICATION_ID + ".provider", tmpFile);
                Log.i(TAG,"uri: $imageUri, BuildConfig.APPLICATION_ID: "+BuildConfig.APPLICATION_ID)
                takeImageResult.launch(imageUri)
            }
        }
    }
}