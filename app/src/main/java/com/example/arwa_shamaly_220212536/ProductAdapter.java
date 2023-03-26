package com.example.arwa_shamaly_220212536;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arwa_shamaly_220212536.databinding.ProductItemBinding;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {
    ArrayList<Product> arrayList;
    OnAction onAction;

    public ProductAdapter(ArrayList<Product> arrayList, OnAction onAction) {
        this.arrayList = arrayList;
        this.onAction = onAction;
    }

    public ArrayList<Product> getArrayList() {
        notifyDataSetChanged();
        return arrayList;
    }

    public void setArrayList(ArrayList<Product> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductItemBinding binding=ProductItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent,false);
        return new ProductHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        int pos =position;
        Product product=arrayList.get(pos);
        holder.productName.setText(product.getProductName());
        holder.quantityAvailable.setText(String.valueOf(product.getQuantityAvailable()));
        holder.hasToShow.setText(product.hasToShow);
        holder.imgProduct.setImageResource(R.drawable.ic_launcher_background);

        holder.imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAction.onDelete(pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ProductHolder extends RecyclerView.ViewHolder{
        TextView productName,quantityAvailable,hasToShow;
        ImageView imgProduct ,imgClose;
        public ProductHolder(@NonNull ProductItemBinding binding) {
            super(binding.getRoot());
            productName=binding.tvProductName;
            imgProduct=binding.imgProduct;
            quantityAvailable=binding.tvQuantityAvailable;
            hasToShow = binding.tvHasToShow;
            imgClose = binding.imgClose;
        }
    }
}
