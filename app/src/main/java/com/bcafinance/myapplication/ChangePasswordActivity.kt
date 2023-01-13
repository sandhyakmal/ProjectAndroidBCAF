package com.bcafinance.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bcafinance.myapplication.R
import kotlinx.android.synthetic.main.activity_change_password.*

class ChangePasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        btnChangePass.setOnClickListener(View.OnClickListener {
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

    }
}