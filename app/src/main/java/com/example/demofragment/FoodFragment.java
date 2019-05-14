package com.example.demofragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FoodFragment extends Fragment {
    View view;
    ListView lvFood;
    ArrayAdapter<String> foodAdapter;
    ArrayList<String> dsfood;
    ItemClickFood itemClickFood;
    public void setItemClickFood(ItemClickFood itemClickFood){
        this.itemClickFood=itemClickFood;
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = (View) inflater.inflate(R.layout.fragment_food, container, false);
        addControls();
        addEvents();
        fakeData();
        return view;
    }

    private void fakeData() {
        for (int i=0; i<100;i++){
            dsfood.add("Món ăn "+i);
        }
        foodAdapter.addAll(dsfood);
        foodAdapter.notifyDataSetChanged();
    }

    private void addEvents() {
        lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemClickFood.isClickFood(dsfood.get(position));
            }
        });
    }

    private void addControls() {
        dsfood= new ArrayList<>();
        lvFood=view.findViewById(R.id.lvFood);
        foodAdapter= new ArrayAdapter<>(view.getContext(),android.R.layout.simple_list_item_1);
        lvFood.setAdapter(foodAdapter);
    }
}
