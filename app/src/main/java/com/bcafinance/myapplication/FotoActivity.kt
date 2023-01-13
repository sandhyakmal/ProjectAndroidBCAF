package com.bcafinance.myapplication

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import kotlinx.android.synthetic.main.activity_foto.*

class FotoActivity : AppCompatActivity() {
    private val REQUEST_CAPTURE_RUMAH = 601
    private val REQUEST_CAPTURE_KTP = 602
    private val REQUEST_CODE_PERMISSION = 999

    override fun onCreate(savedInstanceState: Bundle?) {
//        var tlf1 = intent.getStringExtra("tlf1")
//        var tlf2 = intent.getStringExtra("tlf2")
//        var mailAddress = intent.getStringExtra("mailAddress")
//        var userId = intent.getStringExtra("userId")
//        var agingDate = intent.getStringExtra("agingDate")
//        var accountNumber = intent.getStringExtra("accountNumber")
//        var statusKonsumen = intent.getStringExtra("statusKonsumen")
//        var statusUnit = intent.getStringExtra("statusUnit")
//        var statusAlamat = intent.getStringExtra("statusAlamat")
//        var bertemuDengan = intent.getStringExtra("bertemuDengan")
//        var hasilKunjungan = intent.getStringExtra("hasilKunjungan")
//        var alamatBaru = intent.getStringExtra("alamatBaru")
//        var noHpBaru1 = intent.getStringExtra("noHpBaru1")
//        var noHpBaru2 = intent.getStringExtra("noHpBaru2")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foto)

        btnRumah.setOnClickListener {
            captureCamera(REQUEST_CAPTURE_RUMAH)
        }

        btnKTP.setOnClickListener {
            captureCamera(REQUEST_CAPTURE_KTP)
        }

        btnLanjut4.setOnClickListener{
            intent = Intent(this, SptActivity::class.java)
            startActivity(intent)
        }
    }

    fun captureCamera(RQCode:Int){
        val takeCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(takeCamera, RQCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CAPTURE_KTP && resultCode == AppCompatActivity.RESULT_OK){
            val bitmapImage = data?.extras?.get("data") as Bitmap
            fotoKTP.setImageBitmap(bitmapImage)
        }else{
            val bitmapImage = data?.extras?.get("data") as Bitmap
            fotoRumah.setImageBitmap(bitmapImage)
        }
    }
}