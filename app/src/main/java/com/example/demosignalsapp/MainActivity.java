package com.example.demosignalsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.demosignalsapp.adapter.SignalsAdapter;

import com.example.demosignalsapp.databinding.ActivityMainBinding;
import com.example.demosignalsapp.model.signal.Datum;
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


        /*signalsAdapter = new SignalsAdapter(this);
        mainBinding.recyclerId.setLayoutManager(new LinearLayoutManager(this));
        mainBinding.recyclerId.setAdapter(signalsAdapter);*/

        /*mainBinding.buttonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signalsAdapter.updateDatum(dataModelList);
            }
        });*/


        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.makeApiCall();




        viewModel.getResponseModelData().observe(this, responseModel -> {

            Log.d("res_db_main_activity", "onChanged: model: " + new Gson().toJson(viewModel.getResponseModelData()));

            if (responseModel != null){

                dataModelList = responseModel.getSignals().getData();
                Log.e("SIZE", "onCreate: "+dataModelList.size());

                if (!dataModelList.isEmpty()){

                    setAdapter(dataModelList);
                    //signalsAdapter.updateDatum(dataModelList);
                }


            }

            else {
                Toast.makeText(MainActivity.this, "No Result Found", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void setAdapter(List<Datum> dataModelList) {

        signalsAdapter = new SignalsAdapter(this, dataModelList);
        mainBinding.recyclerId.setLayoutManager(new LinearLayoutManager(this));
        //signalsAdapter.updateDatum(dataModelList);
        mainBinding.recyclerId.setAdapter(signalsAdapter);

    }


}