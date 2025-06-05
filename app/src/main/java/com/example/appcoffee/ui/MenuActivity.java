package com.example.appcoffee.ui;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcoffee.R;
import com.example.appcoffee.util.MenuAdapter;
import com.example.appcoffee.util.Product;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private RecyclerView recyclerMenu;
    private MenuAdapter adapter;
    private List<Product> productList;

    private Button btnCoffee, btnNonCoffee, btnMeals;
    private Button btnHome, btnMenu, btnOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Inisialisasi tombol kategori
        recyclerMenu = findViewById(R.id.recyclerMenu);
        btnCoffee = findViewById(R.id.btnCoffee);
        btnNonCoffee = findViewById(R.id.btnNonCoffee);
        btnMeals = findViewById(R.id.btnMeals);

        // Inisialisasi tombol navigasi
        btnHome = findViewById(R.id.btnHome);
        btnMenu = findViewById(R.id.btnMenu);
        btnOrder = findViewById(R.id.btnOrder);

        // Setup RecyclerView
        recyclerMenu.setLayoutManager(new GridLayoutManager(this, 2));
        productList = new ArrayList<>();
        adapter = new MenuAdapter(productList, this);
        recyclerMenu.setAdapter(adapter);

        // Load default menu
        loadCoffeeMenu();
        setActiveButton(btnCoffee);
        setActiveNavButton(btnMenu);

        // Listener kategori
        btnCoffee.setOnClickListener(v -> {
            loadCoffeeMenu();
            adapter.updateList(productList);
            setActiveButton(btnCoffee);
        });

        btnNonCoffee.setOnClickListener(v -> {
            loadNonCoffeeMenu();
            adapter.updateList(productList);
            setActiveButton(btnNonCoffee);
        });

        btnMeals.setOnClickListener(v -> {
            loadMealsMenu();
            adapter.updateList(productList);
            setActiveButton(btnMeals);
        });

        // Listener tombol navigasi bisa ditambahkan di sini jika diperlukan
        // Contoh:
        // btnHome.setOnClickListener(v -> startActivity(new Intent(this, HomeActivity.class)));
    }

    private void setActiveButton(Button activeButton) {
        int grayColor = ContextCompat.getColor(this, R.color.gray);
        int blackColor = ContextCompat.getColor(this, R.color.black);
        int primaryColor = ContextCompat.getColor(this, R.color.primary_color);
        int whiteColor = ContextCompat.getColor(this, R.color.white);

        // Reset semua tombol
        btnCoffee.setSelected(false);
        btnNonCoffee.setSelected(false);
        btnMeals.setSelected(false);
        btnCoffee.setBackgroundColor(grayColor);
        btnNonCoffee.setBackgroundColor(grayColor);
        btnMeals.setBackgroundColor(grayColor);
        btnCoffee.setTextColor(blackColor);
        btnNonCoffee.setTextColor(blackColor);
        btnMeals.setTextColor(blackColor);

        // Atur tombol aktif
        activeButton.setSelected(true);
        activeButton.setBackgroundColor(primaryColor);
        activeButton.setTextColor(whiteColor);
    }

    private void setActiveNavButton(Button activeButton) {
        btnHome.setSelected(activeButton == btnHome);
        btnMenu.setSelected(activeButton == btnMenu);
        btnOrder.setSelected(activeButton == btnOrder);
    }

    private void loadCoffeeMenu() {
        productList.clear();
        productList.add(new Product("Caramel Macchiato", 35000, R.drawable.logo));
        productList.add(new Product("Hazelnut Coffee", 25000, R.drawable.logo));
        productList.add(new Product("Cocoa Latte", 35000, R.drawable.logo));
        productList.add(new Product("Aren Latte", 25000, R.drawable.logo));
        productList.add(new Product("Avocado Velvet", 35000, R.drawable.logo));
        productList.add(new Product("Ubee Coffee", 35000, R.drawable.logo));
    }

    private void loadNonCoffeeMenu() {
        productList.clear();
        productList.add(new Product("Chocolate Milk", 30000, R.drawable.logo));
        productList.add(new Product("Pandan Aren", 28000, R.drawable.logo));
        productList.add(new Product("Taro Yakult Milk", 32000, R.drawable.logo));
        productList.add(new Product("Vanilla Yakult Milk", 32000, R.drawable.logo));
        productList.add(new Product("Iced Tea", 15000, R.drawable.logo));
        productList.add(new Product("Strawberry Fruity", 35000, R.drawable.logo));
    }

    private void loadMealsMenu() {
        productList.clear();
        productList.add(new Product("Nasi Goreng", 40000, R.drawable.logo));
        productList.add(new Product("Mie Ayam", 35000, R.drawable.logo));
        productList.add(new Product("Roti Bakar", 20000, R.drawable.logo));
    }
}
