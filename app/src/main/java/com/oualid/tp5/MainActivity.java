package com.oualid.tp5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String SANDWICH = "Sandwich";
    public static final String PIZZA = "Pizza";
    public static final String Salade = "Salade";
    public static final String Dessert = "Dessert";
    public static final String Drink = "Drink";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.categories_view);
        List<String> products = new ArrayList<>();
        products.add(SANDWICH);
        products.add(PIZZA);
        products.add(Salade);
        products.add(Dessert);
        products.add(Drink);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, products));
        listView.setOnItemClickListener((p, v, i, d) -> {
            Intent intent = new Intent(this, ProductsActivity.class);
            intent.putExtra("product", products.get(i));
            startActivity(intent);
        });
    }
}