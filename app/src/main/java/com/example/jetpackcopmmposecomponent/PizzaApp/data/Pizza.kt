package com.example.jetpackcopmmposecomponent.PizzaApp.data

import androidx.annotation.DrawableRes
import com.example.jetpackcopmmposecomponent.R

data class Pizza(
    @DrawableRes val image: Int,
    val name: String,
    val description: String,
    val price: String,
)

val pizzaList = listOf(
    Pizza(
        R.drawable.two,
        name = "Margherita",
        description = "Classic pizza with tomato, mozzarella, and basil.",
        price = "$9.99"
    ),
    Pizza(
        R.drawable.three,
        name = "Pepperoni",
        description = "Spicy pepperoni with mozzarella and tomato sauce.",
        price = " $12.99"
    ),
    Pizza(
        R.drawable.four,
        name = "BBQ Chicken",
        description = "Smoky BBQ sauce with grilled chicken, onions, and cheese.",
        price = "$13.99",
    ),
    Pizza(
        R.drawable.two,
        name = "Veggie Delight",
        description = "Loaded with fresh vegetables, olives, and feta cheese.",
        price = "$11.99"
    ),
    Pizza(
        R.drawable.three,
        name = "Hawaiian",
        description = "Tropical mix of ham, pineapple, and mozzarella.",
        price = "$10.99"
    ),
    Pizza(
        R.drawable.four,
        name = "Meat Lover's",
        description = "Packed with pepperoni, sausage, ham, and bacon.",
        price = "$14.99"
    ),
    Pizza(
        R.drawable.two,
        name = "Cheese Explosion",
        description = "For cheese lovers: extra mozzarella, cheddar, and parmesan.",
        price = "$10.49"
    ),
    Pizza(
        R.drawable.three,
        name = "Buffalo Chicken",
        description = "Spicy buffalo sauce with grilled chicken and blue cheese.",
        price = "$13.49"
    ),
    Pizza(
        R.drawable.four,
        name = "Supreme",
        description = "Combination of meats, vegetables, and a special sauce.",
        price = "$14.49"
    ),
    Pizza(
        R.drawable.two,
        name = "Mediterranean",
        description = "Topped with olives, sun-dried tomatoes, and goat cheese.",
        price = "$12.49"
    )
)