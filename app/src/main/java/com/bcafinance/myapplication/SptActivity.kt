package com.bcafinance.myapplication

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.net.ConnectivityManager
import android.net.Network
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bcafinance.myapplication.adapter.TertundaAdapter
import com.bcafinance.myapplication.database.KunjunganLocalDB
import com.bcafinance.myapplication.model.DataKunjungan
import com.bcafinance.myapplication.model.DataKunjunganLocal
import com.bcafinance.myapplication.model.DataKunjunganUpdate
import com.bcafinance.myapplication.model.ResponseDataKunjungan
import com.example.projectjuara.service.NetworkConfig
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_spt.*
import kotlinx.android.synthetic.main.fragment_order_tertunda.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response


class SptActivity : AppCompatActivity() {
    private var locationManager : LocationManager? = null

    private val LOCATION_PERMISSION_REQ_CODE = 1000;
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var latitude: Double = 0.0
    private var longitude: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        var tlf1 = intent.getStringExtra("tlf1")
        var tlf2 = intent.getStringExtra("tlf2")
        var postalCode = intent.getStringExtra("postalCode")
        var mailAddress = intent.getStringExtra("mailAddress")
        var userId = intent.getStringExtra("userId")
        var agingDate = intent.getStringExtra("agingDate")
        var accountId = intent.getStringExtra("accountId")
        var accountNumber = intent.getStringExtra("accountNumber")
        var statusKonsumen = intent.getStringExtra("statusKonsumen")
        var statusUnit = intent.getStringExtra("statusUnit")
        var statusAlamat = intent.getStringExtra("statusAlamat")
        var bertemuDengan = intent.getStringExtra("bertemuDengan")
        var hasilKunjungan = intent.getStringExtra("hasilKunjungan")
        var remark = intent.getStringExtra("remark")
        var fotoKtpPath = intent.getStringExtra("fotoKtpPath")
        var fotoRumahPath = intent.getStringExtra("fotoRumahPath")
        var jamInp:String? = ""
        var menitInp:String? = ""
        var jamKunjungan:String? = ""
        var isSpt:Boolean? = false
        var isFilled:Boolean? = false
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spt)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        getCurrentLocation()

        inpJam.setIs24HourView(true)

        radioTerkirim.setOnClickListener {
            isSpt = true
            isFilled = true
        }
        radioTidak.setOnClickListener {
            isSpt = false
            isFilled = true
        }

        inpJam.setOnClickListener {
            if(inpJam.hour.toInt() < 10){
                jamInp = "0${inpJam.hour.toString()}"
            }else{
                jamInp = inpJam.hour.toString()
            }

            if(inpJam.minute.toInt() < 10){
                menitInp = "0${inpJam.minute.toString()}"
            }else{
                menitInp = inpJam.minute.toString()
            }
            jamKunjungan = "${jamInp}:${menitInp}"
        }
        btnSubmit.setOnClickListener {
            val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = cm.activeNetworkInfo
            if(inpPenerima.text.toString().equals("")){
                Toast.makeText(applicationContext, "Isi Penerima Dahulu!", Toast.LENGTH_LONG).show()
            }else if(isFilled == false){
                Toast.makeText(applicationContext, "Isi Keterangan SPT Dahulu!", Toast.LENGTH_LONG).show()

            }else{
                if(networkInfo != null && networkInfo.isConnected == true){

                    var dataKunjungan = DataKunjungan(
                        hasilKunjungan,
                        postalCode,
                        inpPenerima.text.toString(),
                        tlf1,
                        jamKunjungan,
                        mailAddress,
                        tlf2,
                        remark,
                        true,
                        bertemuDengan,
                        userId?.toInt(),
                        fotoRumahPath,
                        isSpt,
                        statusKonsumen,
                        accountId,
                        fotoKtpPath,
                        statusAlamat,
                        agingDate,
                        statusUnit,
                        "${latitude} , ${longitude}")

                    var dataKunjunganUpdate = DataKunjunganUpdate(
                        accountId,
                        accountNumber,
                        mailAddress,
                        tlf1,
                        tlf2,
                        userId?.toInt(),
                    )

                    NetworkConfig().getServiceKunjungan().sendKunjungan(dataKunjungan).enqueue(object : retrofit2.Callback<ResponseDataKunjungan>{
                        override fun onResponse(
                            call: Call<ResponseDataKunjungan>,
                            response: Response<ResponseDataKunjungan>
                        ) {
                            if(response.isSuccessful){
                                Toast.makeText(applicationContext, response.message(), Toast.LENGTH_LONG).show()
                            }
                        }

                        override fun onFailure(call: Call<ResponseDataKunjungan>, t: Throwable) {
                            Log.e("error post", t.printStackTrace().toString())
                        }
                    })

                    NetworkConfig().getServiceKunjungan().updateData(dataKunjunganUpdate).enqueue(object : retrofit2.Callback<ResponseDataKunjungan>{
                        override fun onResponse(
                            call: Call<ResponseDataKunjungan>,
                            response: Response<ResponseDataKunjungan>
                        ) {
                            if (response.isSuccessful){
                                Toast.makeText(applicationContext, response.message(), Toast.LENGTH_LONG).show()
                            }
                        }

                        override fun onFailure(call: Call<ResponseDataKunjungan>, t: Throwable) {
                            Log.e("error post", t.printStackTrace().toString())
                        }
                    })
                }else{
                    var dataKunjunganLocal = DataKunjunganLocal(
                        0,
                        hasilKunjungan,
                        postalCode,
                        inpPenerima.text.toString(),
                        tlf1,
                        jamKunjungan,
                        mailAddress,
                        tlf2,
                        remark,
                        true,
                        bertemuDengan,
                        userId?.toInt(),
                        fotoRumahPath,
                        isSpt,
                        statusKonsumen,
                        accountId?.toInt(),
                        fotoKtpPath,
                        statusAlamat,
                        agingDate,
                        statusUnit)

                    GlobalScope.launch {
                        KunjunganLocalDB.getInstance(applicationContext).kunjunganDao().insertKunjungan(dataKunjunganLocal)
                        runOnUiThread {
                            Toast.makeText(applicationContext, "Offline, Data Tesimpan", Toast.LENGTH_LONG).show()
                        }
                    }
                }

                finish()
                val intent = Intent(this, MenuUtamaActivity::class.java)
                getIntent().removeExtra("tlf1")
                getIntent().removeExtra("tlf2")
                getIntent().removeExtra("postalCode")
                getIntent().removeExtra("mailAddress")
                getIntent().removeExtra("userId")
                getIntent().removeExtra("agingDate")
                getIntent().removeExtra("accountId")
                getIntent().removeExtra("statusKonsumen")
                getIntent().removeExtra("statusUnit")
                getIntent().removeExtra("statusAlamat")
                getIntent().removeExtra("bertemuDengan")
                getIntent().removeExtra("hasilKunjungan")
                getIntent().removeExtra("remark")
                getIntent().removeExtra("fotoKtpPath")
                getIntent().removeExtra("fotoRumahPath")
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
        }
    }

    private fun getCurrentLocation() {
        // checking location permission
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // request permission
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQ_CODE);
            return
        }
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                // getting the last known or current location
                latitude = location.latitude
                longitude = location.longitude
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed on getting current location",
                    Toast.LENGTH_SHORT).show()
            }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            LOCATION_PERMISSION_REQ_CODE -> {
                if (grantResults.isNotEmpty() &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission granted
                } else {
                    // permission denied
                    Toast.makeText(this, "You need to grant permission to access location",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}