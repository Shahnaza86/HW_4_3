package com.example.hw_4_3;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hw_4_3.databinding.ItemContinentBinding;
import com.example.hw_4_3.databinding.ItemCountryBinding;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryViewHolder> {
    private ArrayList<Country> countryList;

    public CountryAdapter(ArrayList<Country> countryList) {
        this.countryList = countryList;
    }


    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CountryViewHolder(ItemCountryBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.bind(countryList.get(position));
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }
}


class CountryViewHolder extends RecyclerView.ViewHolder {
    private ItemCountryBinding binding;
    public CountryViewHolder(ItemCountryBinding binding) {
        super(binding.getRoot());
        this.binding=binding;
    }
    public void bind(Country country){
        binding.tvCountry.setText(country.getName());
        binding.tvCapital.setText(country.getCapital());
        Glide.with(binding.imgFlag).load(country.getFlag()).into(binding.imgFlag);
    }}