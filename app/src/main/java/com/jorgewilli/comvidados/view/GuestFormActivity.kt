package com.jorgewilli.comvidados.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.jorgewilli.comvidados.R
import com.jorgewilli.comvidados.service.constants.GuestConstans
import com.jorgewilli.comvidados.viewmodel.GuestFormViewModel
import kotlinx.android.synthetic.main.activity_guest_form.*

class GuestFormActivity : AppCompatActivity(), OnClickListener {

    private lateinit var mViewModel: GuestFormViewModel
    private var mGuestId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_form)

        mViewModel = ViewModelProvider(this)[GuestFormViewModel::class.java]

        setListners()
        observe(view = findViewById(android.R.id.content))
        loadData()

        radio_button_present.isChecked = true
    }

    private fun loadData() {
        val bundle = intent.extras
        if (bundle != null){
            mGuestId = bundle.getInt(GuestConstans.GUESTID)
            mViewModel.load(mGuestId)
        }
    }


    private fun observe(view: View) {
        mViewModel.saveGuest.observe(this, Observer {
            if (it){
                Snackbar.make( view, "Sucesso", Snackbar.LENGTH_LONG).show()
            }else{
                Snackbar.make( view, "Falha", Snackbar.LENGTH_LONG).show()
            }
            finish()
        })

        mViewModel.guest.observe(this, Observer {
            edit_name.setText(it.name)
            if (it.presence){
                radio_button_present.isChecked = true
            }else{
                radio_button_absent.isChecked = true
            }
        })
    }

    private fun setListners(){
        button_salve.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.button_salve) {
            mViewModel.save(mGuestId, edit_name.text.toString(), radio_button_present.isChecked)
        }
    }
}