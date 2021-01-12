package com.bas.bac_a_sable_recyclerview_callback;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.Listener {
    // 1 - Implementation de l'interface callback (créé dans MyAdapter)

    private RecyclerView recyclerView;
    private List<MyObject> cities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }


    // 2 - L'implémentation de l'interface, oblige la réécriture de ses méthodes
    @Override
    public void onClickButton(int position) {
        MyObject object = ((MyAdapter)recyclerView.getAdapter()).getObject(position);
        Toast.makeText(this, "Clic sur "+object.getText(), Toast.LENGTH_SHORT).show();
    }


    private void init() {
        ajouterVilles();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 3 - Passing reference of callback
        recyclerView.setAdapter(new MyAdapter(cities, this));
    }

    private void ajouterVilles() {
        cities.add(new MyObject("France", 123));
        cities.add(new MyObject("Angleterre", 234));
        cities.add(new MyObject("Allemagne", 345));
        cities.add(new MyObject("Espagne", 456));
        cities.add(new MyObject("Italie", 567));
        cities.add(new MyObject("Russie", 789));
    }

}
