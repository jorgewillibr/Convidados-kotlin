package com.jorgewilli.comvidados.service.repository.controle

import android.content.Context
import com.jorgewilli.comvidados.service.constants.GuestConstans
import com.jorgewilli.comvidados.service.repository.sqlite.GuestRepository

class EscolheBanco {
    companion object{
        fun getBanco(context: Context): Repository {
            return if (GuestConstans.BANCO.ROOM) {
                GuestRepository.getInstance(context = context)
            } else {
                com.jorgewilli.comvidados.service.repository.room.GuestRepository(context = context)
            }
        }
    }
}