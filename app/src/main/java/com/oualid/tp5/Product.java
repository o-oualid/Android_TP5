package com.oualid.tp5;

import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.databinding.BindingAdapter;

public class Product {

    @DrawableRes
    public int drawable;
    private final String name;
    private final String description;
    private final float price;

    public Product(@DrawableRes int drawable, String name, String description, float price) {
        this.drawable = drawable;
        this.name = name;
        this.description = description;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price + " €";
    }

    @BindingAdapter("image")
    public static void loadImage(ImageView view, @DrawableRes int drawable) {
        view.setImageResource(drawable);
    }
}
