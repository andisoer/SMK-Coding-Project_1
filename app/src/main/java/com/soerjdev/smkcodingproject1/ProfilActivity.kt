package com.soerjdev.smkcodingproject1

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.os.bundleOf
import kotlinx.android.synthetic.main.activity_profil.*

class ProfilActivity : AppCompatActivity() {

    companion object{
        val REQUEST_CODE_EDIT_NAMA = 10
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        initView()
    }

    private fun initView() {
        btnAbout.setOnClickListener {
            intentTo(Intent(this, AboutActivity::class.java)) }
        btnEditNama.setOnClickListener { intentToEditNama() }
        btnDial.setOnClickListener { dialPhoneNumber(tvTelpProfile.text.toString()) }

        getDataIntent()
    }

    private fun getDataIntent() {
        val bundle = intent.extras
        val varNama = bundle?.getString("name")
        val varJK = bundle?.getString("gender")
        val varUmur = bundle?.getString("age")
        val varEmail = bundle?.getString("email")
        val varTelp = bundle?.getString("phone")
        val varAlamat = bundle?.getString("address")

        tvNamaProfile.text = varNama
        tvJKProfile.text = varJK
        tvUmurProfile.text = varUmur
        tvEmailProfile.text = varEmail
        tvTelpProfile.text = varTelp
        tvAlamatProfile.text = varAlamat

    }

    private fun dialPhoneNumber(telpNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$telpNumber")
        }
        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }

    private fun intentToEditNama() {
        val intent = Intent(this, EditNamaActivity::class.java)

        val varNama = tvNamaProfile.text.toString()
        intent.putExtra("name", varNama)

        startActivityForResult(intent, REQUEST_CODE_EDIT_NAMA)
    }

    private fun intentTo(intent: Intent) {
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE_EDIT_NAMA){
            if(resultCode == Activity.RESULT_OK){
                val resultData = data?.getStringExtra("name")
                tvNamaProfile.text = resultData
            }else{
                Toast.makeText(this, "Edit cancelled", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
