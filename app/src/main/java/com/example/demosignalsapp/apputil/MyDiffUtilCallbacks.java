package com.example.demosignalsapp.apputil;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.example.demosignalsapp.model.signal.Datum;

import java.util.ArrayList;
import java.util.List;

public class MyDiffUtilCallbacks extends DiffUtil.Callback{

    List<Datum> oldDatum;
    List<Datum> newDatum;

    public MyDiffUtilCallbacks(List<Datum> oldDatum, List<Datum> newDatum) {
        this.oldDatum = oldDatum;
        this.newDatum = newDatum;
    }

    @Override
    public int getOldListSize() {
        return oldDatum != null ? oldDatum.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return newDatum != null ? newDatum.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {

        return true;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {

        int result = newDatum.get(newItemPosition).compareTo(oldDatum.get(oldItemPosition));

        if (result == 0)
            return true;

        return false;
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {

        Datum newData = newDatum.get(newItemPosition);
        Datum oldData = oldDatum.get(oldItemPosition);

        Bundle bundle = new Bundle();


        if (!newData.getStatus().equals(oldData.getStatus())){

            bundle.putString("status", newData.getStatus());
        }

        if (!newData.getCurrency().equals(oldData.getCurrency())){

            bundle.putString("currency", newData.getCurrency());
        }

        if (bundle.size() == 0)
            return null;
        return bundle;

    }
}


























