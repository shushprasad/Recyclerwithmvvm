package com.sushma.recyclerwithmvvm.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sushma.recyclerwithmvvm.R;
import com.sushma.recyclerwithmvvm.models.DataModel;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.viewHolder> {
    private List<DataModel> dataModelList;
    private Context context;

    public DataAdapter(List<DataModel> dataModelList,Context context) {
        this.dataModelList = dataModelList;
        this.context = context;
    }

    public void updateDatalist(List<DataModel> list) {
        this.dataModelList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(dataModelList.get(position).getName());
        Glide.with(holder.title.getContext()).load(dataModelList.get(position).getImage()).into(holder.img);
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, dataModelList.get(position).getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (this.dataModelList != null)
            return this.dataModelList.size();
        else
            return 0;
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView img;
        LinearLayout linearLayout;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleView);
            img = itemView.findViewById(R.id.imageView);
            linearLayout = itemView.findViewById(R.id.linearid);
        }
    }
}
