package com.bcafinance.myapplication
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bcafinance.myapplication.LoginAPI.Retro
import com.bcafinance.myapplication.LoginAPI.UserApi
import com.bcafinance.myapplication.LoginAPI.userRequest
import com.bcafinance.myapplication.LoginAPI.userResponse
import com.bcafinance.myapplication.LoginPreference.Constant
import com.bcafinance.myapplication.LoginPreference.PreferenceHelper
import kotlinx.android.synthetic.main.activity_change_password.*
import kotlinx.android.synthetic.main.activity_change_password.btnChangePassword
import kotlinx.android.synthetic.main.activity_change_password.txtPasswordNew
import kotlinx.android.synthetic.main.activity_change_password.txtPasswordOld
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_menu.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChangePasswordActivity : AppCompatActivity() {

    lateinit var sharedPref: PreferenceHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        sharedPref = PreferenceHelper(this)

        btnChangePassword.setOnClickListener(View.OnClickListener {
            if(!txtPasswordOld.text.toString().equals("") && !txtPasswordNew.text.toString().equals("") && !txtPasswordRetype.text
                    .toString().equals("")){
                if (txtPasswordNew.text.toString().equals(txtPasswordRetype.text.toString())){
                    changePassword()
                }else{
                    Toast.makeText(this, "Password tidak sama", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this, "Isi semua field", Toast.LENGTH_LONG).show()
            }
        })


    }

    fun changePassword(){
        val request = userRequest()
        request.id = sharedPref.getString(Constant.PREF_ID)
        request.password = txtPasswordNew.text.toString()
        request.activated = true
        if(txtPasswordOld.text.toString().equals(sharedPref.getString(Constant.PREF_PASSWORD))){
            val retro = Retro().getRetroClientInstance().create(UserApi::class.java)
            retro.changePassword(request).enqueue(object : Callback<userResponse> {
                override fun onResponse(call: Call<userResponse>, response: Response<userResponse>) {
                    moveIntent()
                    Toast.makeText(applicationContext, "Password berhasil diupdate, Silahkan Login Kembali", Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<userResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, "Password GAGAL diupdate, Silahkan coba lagi", Toast.LENGTH_LONG).show()
                    changePassword()
                }
            })
        }else{
            Toast.makeText(applicationContext, "Password salah", Toast.LENGTH_LONG).show()
        }

    }

    fun moveIntent(){
        sharedPref.clear()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}