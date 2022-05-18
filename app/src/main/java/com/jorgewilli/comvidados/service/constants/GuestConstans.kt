package com.jorgewilli.comvidados.service.constants

class GuestConstans private constructor(){
    companion object {
        const val GUESTID = "guestID"
    }

    object FILTER{
        const val EMPTY = 0
        const val PRESENT = 1
        const val ABSENT = 2
    }
    object BANCO{
        const val SQLITE = true
        const val ROOM = false
    }
}