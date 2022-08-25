package com.sushma.recyclerwithmvvm.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sushma.recyclerwithmvvm.R;
import com.sushma.recyclerwithmvvm.models.DataModel;

import java.util.ArrayList;
import java.util.List;

public class DataListViewModel extends ViewModel {

    private MutableLiveData<List<DataModel>> dataModelList;

    public DataListViewModel() {
        dataModelList = new MutableLiveData<>();
    }

    public MutableLiveData<List<DataModel>> getDataModelList() {
        return dataModelList;
    }

    public void makeDataRespones() {

        ArrayList<DataModel> list= new ArrayList();
        list.add(new DataModel("Shubham",R.drawable.img1));
        list.add(new DataModel("Shital",R.drawable.img2));
        list.add(new DataModel("Ravi",R.drawable.img3));
        list.add(new DataModel("Durgesh ",R.drawable.img1));

        dataModelList.postValue(list);
    }

}
