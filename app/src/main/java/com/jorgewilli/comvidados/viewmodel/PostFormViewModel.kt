package com.jorgewilli.comvidados.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jorgewilli.comvidados.service.model.PostModel
import com.jorgewilli.comvidados.service.repository.comsumer.RetrofitClient
import com.jorgewilli.comvidados.service.repository.comsumer.metodos.PostService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostFormViewModel : ViewModel() {
    private val mPostList = MutableLiveData<List<PostModel>>()
    val posttList: LiveData<List<PostModel>> = mPostList

    fun load(){
        /*when(filter){
            GuestConstans.FILTER.EMPTY -> {mGuestList.value =  mGuestRepository.getAll()}
            GuestConstans.FILTER.PRESENT -> {mGuestList.value =  mGuestRepository.getPresent()}
            GuestConstans.FILTER.ABSENT -> {mGuestList.value =  mGuestRepository.getAbsent()}
        }*/

        val remote = RetrofitClient.createService(PostService::class.java)
        val call: Call<List<PostModel>> = remote.list()

        val response = call.enqueue(object : Callback<List<PostModel>>{
            override fun onResponse(
                call: Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {
                val s = response.body()
                mPostList.value = s!!
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                val s = t.message
            }

        })

    }
}