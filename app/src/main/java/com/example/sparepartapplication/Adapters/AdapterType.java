package com.example.sparepartapplication.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sparepartapplication.Activity.DetailActivity;
import com.example.sparepartapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterType extends RecyclerView.Adapter<AdapterType.TypeViewHolder> {

    public List<String> typeList;
    public String model;

    public AdapterType(List<String> typeList, String model) {
        this.typeList = typeList;
        this.model = model;
    }

    @NonNull
    @Override
    public TypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TypeViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_type, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TypeViewHolder holder, int position) {
        String type = typeList.get(position);
        Picasso.with(holder.itemView.getContext()).load(type).into(holder.imageType);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("model", model);
                intent.putExtra("type", type);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return typeList.size();
    }

    static class TypeViewHolder extends RecyclerView.ViewHolder {

        ImageView imageType;

        public TypeViewHolder(@NonNull View itemView) {
            super(itemView);

            imageType = itemView.findViewById(R.id.type);
        }
    }
}
