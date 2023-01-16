package com.bcafinance.myapplication

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.bcafinance.myapplication.LoginAPI.Retro
import com.bcafinance.myapplication.LoginAPI.UserApi
import com.bcafinance.myapplication.LoginAPI.userRequest
import com.bcafinance.myapplication.LoginAPI.userResponse
import com.bcafinance.myapplication.LoginPreference.Constant
import com.bcafinance.myapplication.LoginPreference.PreferenceHelper
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {
//
//    val defaultUsername = "user"
//    val defaultPassword = "111"

    lateinit var sharedPref: PreferenceHelper

    private val GPS_REQUEST_CODE = 101
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPref = PreferenceHelper(this)

        initAction()

    }

    fun initAction(){
         btnLogin.setOnClickListener(View.OnClickListener {
             login()
         })
    }


    fun login(){
        val request = userRequest()
        request.uniqId = txtUsername.text.toString().trim()
        request.password = txtPassword.text.toString().trim()

        val retro = Retro().getRetroClientInstance().create(UserApi::class.java)
        retro.login(request).enqueue(object : Callback<userResponse> {

            override fun onResponse(call: Call<userResponse>, response: Response<userResponse>) {

                val lokasi = ContextCompat.checkSelfPermission(this@LoginActivity, Manifest.permission.ACCESS_FINE_LOCATION)
                val User = response.body();



                if(User?.data!=null) {
                    if (lokasi == PackageManager.PERMISSION_DENIED){
                        val permission = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
                        requestPermissions(permission, GPS_REQUEST_CODE)
                    }else if(lokasi == PackageManager.PERMISSION_GRANTED ){

                        //Shared Preference
                        sharedPref.putBoolean(Constant.PREF_IS_LOGIN, true)
                        sharedPref.putString(Constant.PREF_ID, User?.data?.id.toString())
                        sharedPref.putString(Constant.PREF_PASSWORD, User?.data?.password.toString())
                        if (User?.data?.activated==false){
                            Toast.makeText(applicationContext, "Silahkan ganti password dulu", Toast.LENGTH_LONG).show()
                            val intent = Intent(this@LoginActivity, ChangePasswordActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(applicationContext, "Berhasil login", Toast.LENGTH_LONG).show()
                            val intent = Intent(this@LoginActivity, MenuUtamaActivity::class.java)
                            startActivity(intent)
                        }

                    }

                }else{
                    Toast.makeText(applicationContext, "Username / Password salah", Toast.LENGTH_LONG)
                        .show()
                }
            }

            override fun onFailure(call: Call<userResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "Respon gagal", Toast.LENGTH_LONG)
                    .show()
            }
        })

    }



    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            GPS_REQUEST_CODE -> {
                if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    login()
                }else{
                    Toast.makeText(this, "Maaf Permission Denied", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (sharedPref.getBoolean(Constant.PREF_IS_LOGIN)){
            moveIntent()
        }
    }

    private fun moveIntent(){
        startActivity(Intent(this, MenuUtamaActivity::class.java))
        finish()
    }


}