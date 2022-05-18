package com.jorgewilli.comvidados.service.repository.room

import android.content.Context
import com.jorgewilli.comvidados.service.model.GuestModel
import com.jorgewilli.comvidados.service.repository.controle.Repository

class GuestRepository (context: Context) : Repository {

    /**
     * Acesso ao banco de dados
     */
    private val mDataBase = GuestDataBase.getDataBase(context).guestDAO()

    /**
     * Lista todos os convidados
     */
    override fun getAll(): List<GuestModel> {
        return mDataBase.getInvited()
    }

    /**
     * Lista convidados Presentes
     */
    override fun getPresent(): List<GuestModel> {
        return mDataBase.getPresent()
    }

    /**
     * Lista convidados Ausentes
     */
    override fun getAbsent(): List<GuestModel> {
        return mDataBase.getAbsent()
    }

    /**
     * Retorna um Convidado
     */
    //CRUD - Create, Read, Update, Delete
    override fun get(id: Int): GuestModel {
        return mDataBase.get(id)
    }

    /**
     * Salva um Convidado
     */
    override fun save(guest: GuestModel): Boolean {
        return mDataBase.save(guest) > 0
    }

    /**
     * Atualiza um Convidado
     */
    override fun update(guest: GuestModel): Boolean {
        return mDataBase.update(guest) > 0
    }

    /**
     * Deleta um Convidado
     */
    override fun delete(guest: GuestModel) {
        mDataBase.delete(guest)
    }
}