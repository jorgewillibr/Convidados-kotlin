package com.jorgewilli.comvidados.service.repository.comsumer.metodos

import com.jorgewilli.comvidados.service.model.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface PostService {
    @GET("posts")
    fun list():Call<List<PostModel>>

}