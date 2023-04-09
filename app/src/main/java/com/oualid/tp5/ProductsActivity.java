package com.oualid.tp5;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.oualid.tp5.databinding.ProductLayoutBinding;

import java.util.ArrayList;

public class ProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        RecyclerView productListView = findViewById(R.id.productListView);

        ArrayList<Product> pizzaList = new ArrayList<>();
        pizzaList.add(new Product(R.drawable.pizza1, "pizza1", "pizza1", 333));
        pizzaList.add(new Product(R.drawable.pizza2, "pizza2", "pizza2", 111));
        pizzaList.add(new Product(R.drawable.pizza3, "pizza3", "pizza3", 22));

        ArrayList<Product> dessertList = new ArrayList<>();
        dessertList.add(new Product(R.drawable.pizza1, "dessert1", "dessert1", 57));
        dessertList.add(new Product(R.drawable.pizza2, "dessert2", "dessert2", 226));
        dessertList.add(new Product(R.drawable.pizza3, "dessert3", "dessert3", 33));

        ArrayList<Product> sandwichList = new ArrayList<>();
        sandwichList.add(new Product(R.drawable.san1, "sandwich2", "sandwich2", 55));
        sandwichList.add(new Product(R.drawable.san2, "sandwich3", "sandwich3", 642));
        sandwichList.add(new Product(R.drawable.san3, "sandwich1", "sandwich1", 541));

        ArrayList<Product> saladeList = new ArrayList<>();
        saladeList.add(new Product(R.drawable.pizza1, "salade1", "salade1", 534));
        saladeList.add(new Product(R.drawable.pizza2, "salade2", "salade2", 213));
        saladeList.add(new Product(R.drawable.pizza3, "salade3", "salade3", 146));

        ArrayList<Product> drinkList = new ArrayList<>();
        drinkList.add(new Product(R.drawable.pizza1, "drink1", "drink1", 654));
        drinkList.add(new Product(R.drawable.pizza2, "drink2", "drink2", 325));
        drinkList.add(new Product(R.drawable.pizza3, "drink3", "drink3", 583));


        ProductAdapter productAdapter = null;
        switch (getIntent().getExtras().getString("product")) {
            case MainActivity.PIZZA:
                productAdapter = new ProductAdapter(pizzaList);
                break;
            case MainActivity.SANDWICH:
                productAdapter = new ProductAdapter(sandwichList);
                break;
            case MainActivity.Salade:
                productAdapter = new ProductAdapter(saladeList);
                break;
            case MainActivity.Drink:
                productAdapter = new ProductAdapter(drinkList);
                break;
            case MainActivity.Dessert:
                productAdapter = new ProductAdapter(dessertList);
                break;

        }

        if (productAdapter == null) return;
        productListView.setAdapter(productAdapter);
        productListView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), productListView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        ProductLayoutBinding productBinding = DataBindingUtil.getBinding(view);
                        if (productBinding != null) {
                            Product product = productBinding.getItem();
                            Toast.makeText(getApplicationContext(), "the price of " + product.getName() + " is " + product.getPrice(), Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                    }
                })
        );
    }


}