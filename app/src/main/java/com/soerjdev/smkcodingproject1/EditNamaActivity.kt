package com.soerjdev.smkcodingproject1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nama.*
import kotlinx.android.synthetic.main.activity_main.*

class EditNamaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nama)

        initView()
    }

    private fun initView() {
        tbEditNama.setNavigationOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        btnSubmitEditNama.setOnClickListener {
            submitEditNama()
        }

        getDataIntent()

    }

    private fun submitEditNama() {
        val varNama = tieNamaEditNama.text.toString()
        if(!varNama.isEmpty()){
            val result = Intent()

            result.putExtra("name", varNama)
            setResult(Activity.RESULT_OK, result)

        }else{

            setResult(Activity.RESULT_CANCELED)

        }
        finish()
    }

    private fun getDataIntent() {
        val intent = intent.extras
        val varNama = intent?.getString("name")

        tieNamaEditNama.setText(varNama)
    }
}
