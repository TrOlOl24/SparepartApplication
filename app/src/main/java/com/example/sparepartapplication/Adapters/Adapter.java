package com.example.sparepartapplication.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sparepartapplication.R;
import com.example.sparepartapplication.Room.SparePart;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.SparePartViewHolder>{

    public List<SparePart> spareParts;

    public Adapter(List<SparePart> spareParts) {
        this.spareParts = spareParts;
    }

    @NonNull
    @Override
    public SparePartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SparePartViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SparePartViewHolder holder, int position) {
        SparePart sparePart = spareParts.get(position);
        holder.textNameDetail.setText(sparePart.getName());
        holder.textPriceDetail.setText(sparePart.getPrice());
        holder.textNumberDetail.setText(sparePart.getNumber());
        holder.textTypeDetail.setText(sparePart.getType());
        holder.textModelDetail.setText(sparePart.getModel());
        holder.textDescription1Detail.setText(sparePart.getDescription1());
        holder.textDescription2Detail.setText(sparePart.getDescription2());
        holder.textDescription3Detail.setText(sparePart.getDescription3());
        Picasso.with(holder.itemView.getContext()).load(sparePart.getDetail_picture()).into(holder.imageDetail);
    }

    @Override
    public int getItemCount() {
        return spareParts.size();
    }

    public void filterList(List<SparePart> filterList) {
        spareParts = filterList;
        notifyDataSetChanged();
    }

    static class SparePartViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageDetail;
        public TextView textNameDetail, textTypeDetail, textModelDetail,textPriceDetail, textNumberDetail,
                textDescription1Detail, textDescription2Detail,textDescription3Detail;

        public SparePartViewHolder(@NonNull View itemView) {
            super(itemView);

            imageDetail = itemView.findViewById(R.id.detail_image);
            textNameDetail = itemView.findViewById(R.id.detail_name);
            textPriceDetail = itemView.findViewById(R.id.detail_price);
            textNumberDetail = itemView.findViewById(R.id.detail_number);
            textTypeDetail = itemView.findViewById(R.id.detail_type);
            textModelDetail = itemView.findViewById(R.id.detail_model);
            textDescription1Detail = itemView.findViewById(R.id.detail_description1);
            textDescription2Detail = itemView.findViewById(R.id.detail_description2);
            textDescription3Detail = itemView.findViewById(R.id.detail_description3);
        }
    }
}
