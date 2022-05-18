package com.jorgewilli.comvidados.view.listener

import com.jorgewilli.comvidados.service.model.GuestModel

interface GuestListener {
    fun onClick(id: Int)
    fun onDelete(guest: GuestModel)
}