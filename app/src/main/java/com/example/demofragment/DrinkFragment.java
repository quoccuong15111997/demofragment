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

public class DrinkFragment extends Fragment {
    View view;
    ListView lvDrink;
    ArrayAdapter<String> drinkAdapter;
    ArrayList<String> dsDrink;
    ItemDrinkClick itemDrinkClick;

    public void setItemDrinkClick(ItemDrinkClick itemDrinkClick){
        this.itemDrinkClick=itemDrinkClick;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = (View) inflater.inflate(R.layout.fragment_drink, container, false);
        addControls();
        addEvents();
        fakeData();
        return view;
    }

    private void fakeData() {
        for (int i=0; i<100;i++){
            dsDrink.add("Nước uống "+i);
        }
        drinkAdapter.addAll(dsDrink);
        drinkAdapter.notifyDataSetChanged();
    }

    private void addEvents() {
        lvDrink.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemDrinkClick.isClickDrink(dsDrink.get(position));
            }
        });
    }

    private void addControls() {
        dsDrink= new ArrayList<>();
        lvDrink=view.findViewById(R.id.lvDrink);
        drinkAdapter= new ArrayAdapter<>(view.getContext(),android.R.layout.simple_list_item_1);
        lvDrink.setAdapter(drinkAdapter);
    }
}
