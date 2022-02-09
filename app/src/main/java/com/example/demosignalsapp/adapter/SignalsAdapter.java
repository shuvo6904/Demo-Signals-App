package com.example.demosignalsapp.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demosignalsapp.apputil.MyDiffUtilCallbacks;
import com.example.demosignalsapp.apputil.NewDiffCallback;
import com.example.demosignalsapp.databinding.SingleRowDataBinding;
import com.example.demosignalsapp.model.signal.Datum;

import java.util.List;

public class SignalsAdapter extends RecyclerView.Adapter<SignalsAdapter.SignalsViewHolder> {

    Context context;
    List<Datum> dataModelList;

    public SignalsAdapter(Context context) {
        this.context = context;
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

        public void setDataList(Datum dataModel) {
            singleRowDataBinding.statusId.setText(dataModel.getStatus());
            singleRowDataBinding.currencyId.setText(dataModel.getCurrency());
        }
    }


    public void updateDatum(List<Datum> newDatum) {
        NewDiffCallback diffCallback = new NewDiffCallback(dataModelList, newDatum);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);
        dataModelList.clear();
        dataModelList.addAll(newDatum);
        diffResult.dispatchUpdatesTo(this);
    }


}





















