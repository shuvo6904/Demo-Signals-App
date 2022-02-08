package com.example.demosignalsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.demosignalsapp.adapter.SignalsAdapter;
import com.example.demosignalsapp.databinding.ActivityMainBinding;
import com.example.demosignalsapp.model.DataModel;
import com.example.demosignalsapp.model.ResponseModel;
import com.example.demosignalsapp.viewmodel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    SignalsAdapter signalsAdapter;
    List<DataModel> dataModelList;
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

        viewModel.getMainActivityObserver().observe(this, new Observer<ResponseModel>() {
            @Override
            public void onChanged(ResponseModel responseModel) {
                if (responseModel != null){
                    dataModelList = responseModel.getSignals().getDataModel();
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