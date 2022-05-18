package com.jorgewilli.comvidados.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jorgewilli.comvidados.service.constants.GuestConstans
import com.jorgewilli.comvidados.service.model.GuestModel
import com.jorgewilli.comvidados.service.repository.controle.EscolheBanco
import com.jorgewilli.comvidados.service.repository.controle.Repository
import com.jorgewilli.comvidados.service.repository.sqlite.GuestRepository

class GuestsViewModel(application: Application) : AndroidViewModel(application) {

    //private val mGuestRepository = GuestRepository.getInstance(application.applicationContext)
    private val mGuestRepository = EscolheBanco.getBanco(application.applicationContext)

    private val mGuestList = MutableLiveData<List<GuestModel>>()
    val guestList: LiveData<List<GuestModel>> = mGuestList

    fun load(filter: Int){
        when(filter){
            GuestConstans.FILTER.EMPTY -> {mGuestList.value =  mGuestRepository.getAll()}
            GuestConstans.FILTER.PRESENT -> {mGuestList.value =  mGuestRepository.getPresent()}
            GuestConstans.FILTER.ABSENT -> {mGuestList.value =  mGuestRepository.getAbsent()}
        }
    }

    fun delete(guest: GuestModel) {
       mGuestRepository.delete(guest)
    }
}