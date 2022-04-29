package com.example.sidedish.repository

import com.example.sidedish.model.AccessToken
import com.example.sidedish.model.MenuData

interface LoginDataSource {

    suspend fun loadToken(): AccessToken
}