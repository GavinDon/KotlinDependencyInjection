package com.gavin.kotlindependencyinjection.network

import io.reactivex.Observable
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.*

/**
 * description:通用的的api接口
 * Created by liNan on 2018/9/26 15:33

 */
interface ApiService {

    @GET
    fun get(@Url url: String, @QueryMap maps: Map<String, String>): Observable<ResponseBody>

    @FormUrlEncoded
    @POST
    fun post(@Url url:String, @FieldMap maps:Map<String, String>) : Observable<ResponseBody>


    @POST
    @Headers("Content-Type: application/json", "Accept: application/json")
    fun postJson(@Url url: String, @Body jsonBody: RequestBody): Observable<ResponseBody>
}