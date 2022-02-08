package com.example.demosignalsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.demosignalsapp.adapter.SignalsAdapter;
import com.example.demosignalsapp.databinding.ActivityMainBinding;
import com.example.demosignalsapp.model.signal.Datum;
import com.example.demosignalsapp.model.signal.DemoResponse;
import com.example.demosignalsapp.viewmodel.MainActivityViewModel;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    SignalsAdapter signalsAdapter;
    List<Datum> dataModelList;
    MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);

        signalsAdapter = new SignalsAdapter(this, dataModelList);
        mainBinding.recyclerId.setAdapter(signalsAdapter);


        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        viewModel.getMainActivityObserver().observe(this, new Observer<DemoResponse>() {
            @Override
            public void onChanged(DemoResponse responseModel) {
                Log.d("res_db", "onChanged: model: " + new Gson().toJson(responseModel));
                if (responseModel != null){
                    dataModelList = responseModel.getSignals().getData();
                    signalsAdapter.setDataModelList(dataModelList);
                }
                else {
                    Toast.makeText(MainActivity.this, "No Result Found", Toast.LENGTH_SHORT).show();
                }
            }
        });


        viewModel.makeApiCall();

    }
}