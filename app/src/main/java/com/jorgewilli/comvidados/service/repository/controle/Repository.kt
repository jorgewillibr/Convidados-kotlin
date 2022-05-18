package com.jorgewilli.comvidados.service.repository.controle

import com.jorgewilli.comvidados.service.model.GuestModel

interface Repository {

    fun getAll(): List<GuestModel>
    fun getPresent(): List<GuestModel>
    fun getAbsent(): List<GuestModel>
    fun get(id: Int): GuestModel?
    fun save(guest: GuestModel): Boolean
    fun update(guest: GuestModel): Boolean
    fun delete(guest: GuestModel)
}