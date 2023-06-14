package com.example.sparepartapplication.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.sparepartapplication.Activity.TypeActivity;
import com.example.sparepartapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterModel extends RecyclerView.Adapter<AdapterModel.ModelViewHolder> {

    public List<String> modelList;

    public AdapterModel(List<String> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ModelViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_model, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ModelViewHolder holder, int position) {
        String model = modelList.get(position);
        Picasso.with(holder.itemView.getContext()).load(model).into(holder.imageModel);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, TypeActivity.class);
                intent.putExtra("model", model);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    static class ModelViewHolder extends RecyclerView.ViewHolder {

        ImageView imageModel;

        public ModelViewHolder(@NonNull View itemView) {
            super(itemView);

            imageModel = itemView.findViewById(R.id.model);
        }
    }
}
