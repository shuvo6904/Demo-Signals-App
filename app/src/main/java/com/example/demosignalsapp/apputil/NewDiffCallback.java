package com.example.demosignalsapp.apputil;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.example.demosignalsapp.model.signal.Datum;

import java.util.List;

public class NewDiffCallback extends DiffUtil.Callback {

    List<Datum> mOldDataList;
    List<Datum> mNewDataList;

    public NewDiffCallback(List<Datum> mOldDataList, List<Datum> mNewDataList) {
        this.mOldDataList = mOldDataList;
        this.mNewDataList = mNewDataList;
    }

    @Override
    public int getOldListSize() {
        return mOldDataList != null ? mOldDataList.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return mNewDataList != null ? mNewDataList.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return true;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        int result = mNewDataList.get(newItemPosition).compareTo(mOldDataList.get(oldItemPosition));
        if (result == 0)
            return true;
        return false;
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {

        Datum newData = mNewDataList.get(newItemPosition);
        Datum oldData = mOldDataList.get(oldItemPosition);

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

        //return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}


























