package com.example.sidedish.network

import com.example.sidedish.model.*
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @Headers("Content-Type: application/json")
    @GET("products?categoryId=1")
    suspend fun getMainMenu(): Response<MenuData>

    @Headers("Content-Type: application/json")
    @GET("products?categoryId=2")
    suspend fun getSoupMenu(): Response<MenuData>

    @Headers("Content-Type: application/json")
    @GET("products?categoryId=3")
    suspend fun getSideDish(): Response<MenuData>

    @Headers("Content-Type: application/json")
    @GET("products/{productId}")
    suspend fun getProductDetail(@Path("productId") productId: Int): Response<ProductDetail>

    @Headers("Content-Type: application/json")
    @POST("orders")
    suspend fun orderProduct(@Body postRequest: PostRequest): Response<Error>

    @Headers("Content-Type: application/json")
    @FormUrlEncoded
    @POST("Login")
    suspend fun getToken(
        @Field("userID") userID: String,
        @Field("userPw") userPw: String
    ): Response<AccessToken>
}