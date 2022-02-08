package com.example.demosignalsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demosignalsapp.databinding.SingleRowDataBinding;
import com.example.demosignalsapp.model.DataModel;

import java.util.List;

public class SignalsAdapter extends RecyclerView.Adapter<SignalsAdapter.SignalsViewHolder> {

    Context context;
    List<DataModel> dataModelList;

    public SignalsAdapter(Context context, List<DataModel> dataModelList) {
        this.context = context;
        this.dataModelList = dataModelList;
    }

    public void setDataModelList(List<DataModel> dataModelList){
        this.dataModelList = dataModelList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public SignalsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        SingleRowDataBinding singleRowDataBinding = SingleRowDataBinding.inflate(LayoutInflater.from(context), parent, false);

        return new SignalsViewHolder(singleRowDataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SignalsViewHolder holder, int position) {

        holder.setDataList(dataModelList.get(position));

    }

    @Override
    public int getItemCount() {

        if (this.dataModelList != null){
            return dataModelList.size();
        }
        return 0;
    }

    public class SignalsViewHolder extends RecyclerView.ViewHolder {

        SingleRowDataBinding singleRowDataBinding;

        public SignalsViewHolder(@NonNull SingleRowDataBinding singleRowDataBinding) {
            super(singleRowDataBinding.getRoot());

            this.singleRowDataBinding = singleRowDataBinding;

        }

        public void setDataList(DataModel dataModel) {
            singleRowDataBinding.statusId.setText(dataModel.getStatus());
            singleRowDataBinding.currencyId.setText(dataModel.getCurrency());
        }
    }
}





















