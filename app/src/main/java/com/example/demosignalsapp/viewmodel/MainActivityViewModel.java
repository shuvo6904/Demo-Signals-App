package com.example.demosignalsapp.viewmodel;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.demosignalsapp.model.DataModel;
import com.example.demosignalsapp.model.ResponseModel;
import com.example.demosignalsapp.network.ApiInterface;
import com.example.demosignalsapp.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<ResponseModel> responseModelMutableLiveData;

    public MainActivityViewModel(){
        responseModelMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<ResponseModel> getMainActivityObserver(){
        return responseModelMutableLiveData;
    }

    public void makeApiCall(){

        ApiInterface apiInterface = RetrofitClient.getRetrofit().create(ApiInterface.class);
        Call<ResponseModel> call = apiInterface.getSignals("2372752636289369", "", 1);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                responseModelMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                responseModelMutableLiveData.postValue(null);
            }
        });

    }
}
