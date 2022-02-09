package com.example.demosignalsapp.apputil;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.example.demosignalsapp.model.signal.Datum;

import java.util.List;

public class NewDiffCallback extends DiffUtil.Callback {

    private final List<Datum> mOldEmployeeList;
    private final List<Datum> mNewEmployeeList;

    public NewDiffCallback(List<Datum> oldEmployeeList, List<Datum> newEmployeeList) {
        this.mOldEmployeeList = oldEmployeeList;
        this.mNewEmployeeList = newEmployeeList;
    }

    @Override
    public int getOldListSize() {
        return mOldEmployeeList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewEmployeeList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldEmployeeList.get(oldItemPosition).getId() == mNewEmployeeList.get(
                newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        final Datum oldEmployee = mOldEmployeeList.get(oldItemPosition);
        final Datum newEmployee = mNewEmployeeList.get(newItemPosition);

        return oldEmployee.getId().equals(newEmployee.getId());
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        // Implement method if you're going to use ItemAnimator
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}