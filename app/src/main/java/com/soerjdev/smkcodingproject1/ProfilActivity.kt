package com.soerjdev.smkcodingproject1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import kotlinx.android.synthetic.main.activity_profil.*

class ProfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        initView()
    }

    private fun initView() {
        getDataIntent()
        btnAbout.setOnClickListener {
            intentTo(Intent(this, AboutActivity::class.java)) }
        btnEditNama.setOnClickListener {
            intentTo(Intent(this, EditNamaActivity::class.java)) }
        btnDial.setOnClickListener { dialPhoneNumber(tvTelpProfile.text.toString()) }
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

    private fun intentTo(intent: Intent) {
        startActivity(intent)
    }
}
