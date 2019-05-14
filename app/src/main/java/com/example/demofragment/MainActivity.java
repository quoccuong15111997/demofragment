package com.example.demofragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnfood, btnDrink, btnBack;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemClickFood itemClickFood= new ItemClickFood() {
                    @Override
                    public void isClickFood(String food) {
                        doFoofClick(food);
                    }
                };
                FoodFragment foodFragment= new FoodFragment();
                foodFragment.setItemClickFood(itemClickFood);
                fragmentManager.beginTransaction().replace(R.id.container,foodFragment).addToBackStack("food").commit();
            }
        });
        btnDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemDrinkClick itemDrinkClick= new ItemDrinkClick() {
                    @Override
                    public void isClickDrink(String drink) {
                        doDrinkClick(drink);
                    }
                };
                DrinkFragment drinkFragment= new DrinkFragment();
                drinkFragment.setItemDrinkClick(itemDrinkClick);
                fragmentManager.beginTransaction().replace(R.id.container,drinkFragment).addToBackStack("drink").commit();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.popBackStackImmediate();
            }
        });
    }

    private void doFoofClick(String food) {
        Toast.makeText(MainActivity.this,"Bạn chọn: "+food,Toast.LENGTH_LONG).show();
    }

    private void doDrinkClick(String drink) {
        Toast.makeText(MainActivity.this,"Bạn chọn: "+drink,Toast.LENGTH_LONG).show();
    }


    private void addControls() {
        fragmentManager=getSupportFragmentManager();
        btnfood=findViewById(R.id.btnFood);
        btnDrink=findViewById(R.id.btnDrink);
        btnBack=findViewById(R.id.btnBack);
    }

}
