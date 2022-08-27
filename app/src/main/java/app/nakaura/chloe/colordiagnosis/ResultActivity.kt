package app.nakaura.chloe.colordiagnosis

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.core.view.isVisible
import app.nakaura.chloe.colordiagnosis.databinding.ActivityResultBinding
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import java.io.FileOutputStream as FileOutputStream1


class ResultActivity : AppCompatActivity() {
    private val PERMISSION_WRITE_EX_STR = 1
    private lateinit var binding: ActivityResultBinding
    var pic: Int = 0

    override fun onRequestPermissionsResult(
        requestCode: Int, permission: Array<String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permission, grantResults)

//        saveFile(createFile())
    }
       /* if (grantResults.size <= 0) {
            return
        }
        when (requestCode) {
            PERMISSION_WRITE_EX_STR -> {
                run {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        /// 許可が取れた場合・・・
                        /// 必要な処理を書いておく
                    } else {
                        /// 許可が取れなかった場合・・・
                        Toast.makeText(
                            this,
                            "アプリを起動できません....", Toast.LENGTH_LONG
                        ).show()
                        finish()
                    }
                }
                return
            }
        }*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater).apply { setContentView(this.root) }
        val mainIntent: Intent = Intent(this, MainActivity::class.java)
        mainIntent.getIntExtra("total", 0)
        val total = intent.getIntExtra("total", 0)
        println(total)


        when (total) {
            in 7..8 -> {
                binding.redText.isVisible = true
                binding.redText2.isVisible = true
                binding.redText3.isVisible = true
                binding.redText4.isVisible = true
                binding.redSquare.isVisible = true
                pic = R.drawable.red
                println("赤")
            }
            in 9..10 -> {
                println("ピンク")
                binding.pinkText.isVisible = true
                binding.pinkText2.isVisible = true
                binding.pinkText3.isVisible = true
                binding.pinkText4.isVisible = true
                binding.pinkSquare.isVisible = true
                pic = R.drawable.pink
            }
            in 11..12 -> {
                binding.yellowText.isVisible = true
                binding.yellowText2.isVisible = true
                binding.yellowText3.isVisible = true
                binding.yellowText4.isVisible = true
                binding.yellowSquare.isVisible = true
                println("黄")
                pic = R.drawable.yellow
            }
            in 13..14 -> {
                binding.greenText.isVisible = true
                binding.greenText2.isVisible = true
                binding.greenText3.isVisible = true
                binding.greenText4.isVisible = true
                binding.greenSquare.isVisible = true
                println("緑")
                pic = R.drawable.green
            }
            in 15..16 -> {
                binding.blueText.isVisible = true
                binding.blueText2.isVisible = true
                binding.blueText3.isVisible = true
                binding.blueText4.isVisible = true
                binding.blueSquare.isVisible = true
                println("青")
                pic = R.drawable.blue
            }
            in 17..18 -> {
                binding.blackText.isVisible = true
                binding.blackText2.isVisible = true
                binding.blackText3.isVisible = true
                binding.blackText4.isVisible = true
                binding.blackSquare.isVisible = true
                println("黒")
                pic = R.drawable.black
            }
            in 19..21 -> {
                binding.purpleText.isVisible = true
                binding.purpleText2.isVisible = true
                binding.purpleText3.isVisible = true
                binding.purpleText4.isVisible = true
                binding.purpleSquare.isVisible = true
                println("紫")
                pic = R.drawable.purple
            }
        }

        binding.restartButton.setOnClickListener {
            startActivity(mainIntent)
        }
        binding.facebookButton.setOnClickListener {
            navigateToFacebookUserPage(binding.root.context)
        }
        binding.instagramButton.setOnClickListener {
            navigateToInstagramUserPage(binding.root.context)
        }
        binding.twitterButton.setOnClickListener {
            navigateToTwitterUserPage(binding.root.context)
        }
        binding.downloadImageButton.setOnClickListener {
            saveFile(createFile())
        }
            /*if (ContextCompat.checkSelfPermission(
                    applicationContext,
                    Manifest.permission.CAMERA
                ) == PackageManager.PERMISSION_DENIED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    1
                )
                println("Sendai")
            } else {
                saveFile(createFile())
            }*/


        /*//permission
        val isWriteExternalStorageGranted: Boolean = ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED
        val isReadContacts: Boolean = ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.READ_CONTACTS
        ) == PackageManager.PERMISSION_GRANTED

        if (!isWriteExternalStorageGranted || !isReadContacts) {
            println("Permissions are not granted")
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_CONTACTS
                ),
                PERMISSION_WRITE_EX_STR
            )
        }*/
    }

    //Custom Tab
    fun navigateToCustomTab(url: String, context: Context) {
        val uri = Uri.parse(url)
        CustomTabsIntent.Builder().also { builder ->
            builder.setShowTitle(true)
            builder.build().also {
                it.launchUrl(context, uri)
            }
        }
    }

    //Instagram
    fun navigateToInstagramUserPage(context: Context) {
        val url = "https://www.instagram.com/create/story"
        try {
            Intent(Intent.ACTION_VIEW).also {
                it.setPackage("com.instagram.android")
                it.data = Uri.parse(url)
                context.startActivity(it)
            }
        } catch (e: ActivityNotFoundException) {
            Log.d("Instagram", "error")
            navigateToCustomTab(url, context)
        }
    }

    //Twitter
    fun navigateToTwitterUserPage( context: Context) {
        val url = "https://twitter.com/compose/tweet"
        try {
            Intent(Intent.ACTION_VIEW).also {
                it.setPackage("com.twitter.android")
                it.data = Uri.parse(url)
                context.startActivity(it)
            }
        } catch (e: ActivityNotFoundException) {
            navigateToCustomTab(url, context)
        }
    }

    //Facebook
    fun navigateToFacebookUserPage(context: Context) {
        val url = "https://www.facebook.com/"
        try {
            Intent(Intent.ACTION_VIEW).also {
                it.setPackage("com.facebook.katana")
                it.data = Uri.parse("fb://facewebmodal/f?href=$url")
                context.startActivity(it)
            }
        } catch (e: ActivityNotFoundException) {
            navigateToCustomTab(url, context)
        }
    }

    private fun createFile(): File {
        val dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)
        val df = SimpleDateFormat("yyyy-MM-dd-HH-mm-ss")
        val dateString = df.format(Date(System.currentTimeMillis()))
        return File(dir, dateString + ".jpeg")
    }

    private fun saveFile(f: File) {
        val contentValues = ContentValues().apply {
            put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
            put("_data", f.absolutePath)
        }

        contentResolver.insert(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
        val bit = BitmapFactory.decodeResource(resources, pic)

        val ops = FileOutputStream1(f)

        bit.compress(Bitmap.CompressFormat.JPEG, 100, ops)

        ops.close()


    }

}











