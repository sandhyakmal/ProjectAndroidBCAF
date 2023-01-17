package com.bcafinance.myapplication

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_foto.*
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

class FotoActivity : AppCompatActivity() {
    private val REQUEST_CAPTURE_RUMAH = 601
    private val REQUEST_CAPTURE_KTP = 602
    private val REQUEST_CODE_CAMERA = 999
    var fotoKtpPath:String? = null
    var fotoRumahPath:String? = null
    var isFotoKtp:Boolean = false
    var isFotoRumah:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        var tlf1 = intent.getStringExtra("tlf1")
        var tlf2 = intent.getStringExtra("tlf2")
        var postalCode = intent.getStringExtra("postalCode")
        var mailAddress = intent.getStringExtra("mailAddress")
        var userId = intent.getStringExtra("userId")
        var agingDate = intent.getStringExtra("agingDate")
        var accountNumber = intent.getStringExtra("accountNumber")
        var accountId = intent.getStringExtra("accountId")
        var statusKonsumen = intent.getStringExtra("statusKonsumen")
        var statusUnit = intent.getStringExtra("statusUnit")
        var statusAlamat = intent.getStringExtra("statusAlamat")
        var bertemuDengan = intent.getStringExtra("bertemuDengan")
        var hasilKunjungan = intent.getStringExtra("hasilKunjungan")
        var remark = intent.getStringExtra("remark")


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foto)


        val camera = ContextCompat.checkSelfPermission(this@FotoActivity, Manifest.permission.CAMERA)

//        testing
//        txtTesting.setText("${mailAddress}, ${tlf1}, ${tlf2}")

        if (camera == PackageManager.PERMISSION_DENIED){
            val permission = arrayOf(Manifest.permission.CAMERA)
            requestPermissions(permission, REQUEST_CODE_CAMERA)
        }

        btnRumah.setOnClickListener {
            captureCamera(REQUEST_CAPTURE_RUMAH)
        }

        btnKTP.setOnClickListener {
            captureCamera(REQUEST_CAPTURE_KTP)
        }

        btnLanjut4.setOnClickListener{
            if(isFotoRumah == false || isFotoKtp == false){
                Toast.makeText(applicationContext, "Upload Bukti Foto Kunjungan Dahulu!", Toast.LENGTH_LONG).show()
            }else{
                intent = Intent(this, SptActivity::class.java)
                intent.putExtra("tlf1", tlf1)
                intent.putExtra("tlf2", tlf2)
                intent.putExtra("postalCode", postalCode)
                intent.putExtra("mailAddress", mailAddress)
                intent.putExtra("userId", userId)
                intent.putExtra("agingDate", agingDate)
                intent.putExtra("accountId", accountId)
                intent.putExtra("accountNumber", accountNumber)
                intent.putExtra("statusKonsumen", statusKonsumen)
                intent.putExtra("statusUnit", statusUnit)
                intent.putExtra("statusAlamat", statusAlamat)
                intent.putExtra("bertemuDengan", bertemuDengan)
                intent.putExtra("hasilKunjungan", hasilKunjungan)
                intent.putExtra("remark", remark)
                intent.putExtra("fotoRumahPath", fotoRumahPath)
                intent.putExtra("fotoKtpPath", fotoKtpPath)
                startActivity(intent)
            }
        }
    }

    fun captureCamera(RQCode:Int){
        val takeCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(takeCamera, RQCode)
    }

    fun saveImage(bitmap: Bitmap, requestCode: Int){
        val tanggal = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val extStorage = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString()
        val namaFile = extStorage + "/BCAF_"+ tanggal + ".png"
        var file : File? = null


        file = File(namaFile)
        file?.createNewFile()

        val bos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos)
        val bmData = bos.toByteArray()

        val fos = FileOutputStream(file)
        fos.write(bmData)
        fos.flush()

        if(requestCode == 601){
            fotoRumahPath = namaFile.toString()
        }else{
            fotoKtpPath = namaFile.toString()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            REQUEST_CODE_CAMERA -> {
                if(grantResults.isNotEmpty() && grantResults [0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Permission Berhasil", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this, "Maaf Permission Denied", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CAPTURE_KTP && resultCode == AppCompatActivity.RESULT_OK){
            val bitmapImage = data?.extras?.get("data") as Bitmap
            fotoKTP.setImageBitmap(bitmapImage)
            saveImage(bitmapImage, REQUEST_CAPTURE_KTP)
            isFotoKtp = true
        }else if (requestCode == REQUEST_CAPTURE_RUMAH && resultCode == AppCompatActivity.RESULT_OK){
            val bitmapImage = data?.extras?.get("data") as Bitmap
            fotoRumah.setImageBitmap(bitmapImage)
            saveImage(bitmapImage, REQUEST_CAPTURE_RUMAH)
            isFotoRumah = true
        }
    }
}