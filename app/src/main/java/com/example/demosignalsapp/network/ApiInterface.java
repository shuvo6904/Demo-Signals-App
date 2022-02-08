package com.example.demosignalsapp.network;

import com.example.demosignalsapp.model.DataModel;
import com.example.demosignalsapp.model.ResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("api/get-signals")

    Call<ResponseModel> getSignals(

            @Field("app_id") String app_id,
            @Field("old_new") String old_new,
            @Field("page") Integer page

    );

}
