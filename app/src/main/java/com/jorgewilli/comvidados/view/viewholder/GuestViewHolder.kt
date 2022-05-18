package com.jorgewilli.comvidados.view.viewholder

import android.app.AlertDialog
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jorgewilli.comvidados.R
import com.jorgewilli.comvidados.service.model.GuestModel
import com.jorgewilli.comvidados.view.listener.GuestListener

class GuestViewHolder(view: View, private val listener: GuestListener) : RecyclerView.ViewHolder(view) {

    fun bind(guest: GuestModel) {
        val textName = itemView.findViewById<TextView>(R.id.text_name)
        textName.text = guest.name

        textName.setOnClickListener {
            listener.onClick(guest.id)
        }

        textName.setOnLongClickListener {
            AlertDialog.Builder(itemView.context)
                .setTitle(R.string.remocao_convidado)
                .setMessage(R.string.deseja_remover)
                .setPositiveButton(R.string.remover){ dialog, which ->
                    listener.onDelete(guest)
                }
                .setNegativeButton(R.string.cancelar, null)
                .show()
            true
        }
    }
}