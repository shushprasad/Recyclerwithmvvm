package com.sushma.recyclerwithmvvm.tabFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sushma.recyclerwithmvvm.R;
import com.sushma.recyclerwithmvvm.adapters.DataAdapter;
import com.sushma.recyclerwithmvvm.models.DataModel;
import com.sushma.recyclerwithmvvm.viewmodels.DataListViewModel;

import java.util.List;


public class HomeFragment extends Fragment {

    RecyclerView recview;
    List<DataModel> dataModelList;
    DataListViewModel listViewModel;
    DataAdapter adapter;
    private TextView noresfound;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        recview= view.findViewById(R.id.recview);
        noresfound=view.findViewById(R.id.noresult);

        recview.setLayoutManager(new LinearLayoutManager(getContext()));
        recview.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        adapter=new DataAdapter(dataModelList,getActivity());
        recview.setAdapter(adapter);

        listViewModel= ViewModelProviders.of(this).get(DataListViewModel.class);
       listViewModel.getDataModelList().observe(getActivity(), new Observer<List<DataModel>>() {
           @Override
           public void onChanged(List<DataModel> dataModels) {
               if(dataModels!=null) {
                   dataModelList= dataModels;
                   adapter.updateDatalist(dataModels);
                   noresfound.setVisibility(View.GONE);
               }
               if(dataModels==null)
               {
                   recview.setVisibility(View.GONE);
                   noresfound.setVisibility(View.VISIBLE);
               }
           }
       });
       listViewModel.makeDataRespones();
        return view;

    }
}