package com.example.sidedish.repository

import com.example.sidedish.model.AccessToken
import com.example.sidedish.model.MenuData
import com.example.sidedish.network.RetrofitAPI

class LoginRemoteDataSource: LoginDataSource {
    override suspend fun loadToken(): AccessToken {
        val response = RetrofitAPI.service.getToken()
        return if (response.isSuccessful) response.body() else null
    }

}