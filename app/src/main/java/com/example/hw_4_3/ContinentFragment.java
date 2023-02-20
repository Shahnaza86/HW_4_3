package com.example.hw_4_3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hw_4_3.databinding.ActivityMainBinding;
import com.example.hw_4_3.databinding.FragmentContinentBinding;

import java.util.ArrayList;

public class ContinentFragment extends Fragment implements OnItemClick {

   private FragmentContinentBinding binding;

    private ArrayList<String> continentList;
    private ContinentAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentContinentBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        adapter = new ContinentAdapter(continentList,this);
        binding.rvContinent.setAdapter(adapter);
    }

        private void loadData() {
            continentList=new ArrayList<>();
            continentList.add("Europe");
            continentList.add("Azia");
            continentList.add("Africa");
            continentList.add("North America");
            continentList.add("South America");
        }

    @Override
    public void onItemClick(Integer position) {
        Bundle bundle = new Bundle();
        bundle.putInt("KEY",position);
        CountryFragment countryFragment =new CountryFragment();
        countryFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,countryFragment).addToBackStack(null).commit();

    }

    @NonNull
    @Override
    public CreationExtras getDefaultViewModelCreationExtras() {
        return super.getDefaultViewModelCreationExtras();
    }
}
