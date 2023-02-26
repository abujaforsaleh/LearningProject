package com.bauet.learningproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bauet.learningproject.R;
import com.bauet.learningproject.models.RecyclerViewModel;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>{

    Context context;
    ArrayList<RecyclerViewModel> dataList;

    public MyRecyclerViewAdapter(Context context,ArrayList<RecyclerViewModel>dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.base_row_layout, parent, false);

        return new  MyRecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.MyViewHolder holder, int position) {

        holder.image.setImageResource(dataList.get(position).getImage());
        holder.locationName.setText(dataList.get(position).getPlaceName());
        holder.locationCountry.setText(dataList.get(position).getCountry());
        holder.locationPlace.setText(dataList.get(position).getLocationOfPlace());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView locationName, locationPlace, locationCountry;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            locationName = itemView.findViewById(R.id.placeNameId);
            locationPlace = itemView.findViewById(R.id.placeLocationId);
            locationCountry = itemView.findViewById(R.id.placeCountryId);
            image = itemView.findViewById(R.id.image_view);
        }
    }
}