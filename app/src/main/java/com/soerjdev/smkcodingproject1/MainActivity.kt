package com.soerjdev.smkcodingproject1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*;

class MainActivity : AppCompatActivity() {

    private var varNamaInput : String = ""
    private var varJKInput : String = ""
    private var varUmurInput : String = ""
    private var varEmailInput : String = ""
    private var varTelpInput : String = ""
    private var varAlamatInput : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView();
    }

    private fun initView() {
        setSpinnerDataGender();
        btnSubmitFormBiodata.setOnClickListener{ submitForm() }
    }

    private fun setSpinnerDataGender() {
        val adapter = ArrayAdapter.createFromResource(this, R.array.spinner_gender,
            R.layout.support_simple_spinner_dropdown_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerJKFormBiodata.adapter = adapter
    }

    private fun submitForm(){
        varNamaInput = tieNamaFormBiodata.text.toString()
        varJKInput = spinnerJKFormBiodata.selectedItem.toString()
        varUmurInput = tieUmurFormBiodata.text.toString()
        varEmailInput = tieEmailFormBiodata.text.toString()
        varTelpInput = tieTelpFormBiodata.text.toString()
        varAlamatInput = tieAlamatFormBiodata.text.toString()

        when{
            varNamaInput.isEmpty() -> tieNamaFormBiodata.setError("Masukkan nama anda !")
            varJKInput.equals("Pilih Jenis Kelamin", ignoreCase = true) ->
                showToast("Pilih jenis kelamin anda !")
            varUmurInput.isEmpty() -> tieUmurFormBiodata.setError("Masukkan umur anda !")
            varEmailInput.isEmpty() -> tieEmailFormBiodata.setError("Masukkan email anda !")
            varTelpInput.isEmpty() -> tieTelpFormBiodata.setError("Masukkan no telepon anda !")
            varAlamatInput.isEmpty() -> tieAlamatFormBiodata.setError("Masukkan alamat anda !")
            else -> {
                intentToProfil()
            }
        }
    }

    private fun intentToProfil() {

    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}
