package com.example.ejemploretrofit_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.ejemploretrofit_java.retrofit.webservices;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btactualizar;
    adaptardorProducto adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btactualizar=findViewById(R.id.btactualizar);

        //ArrayList<producto> listaproducto=new ArrayList<producto>();

       webservices webservices=new webservices(this);
       webservices.consultaproductos();

         recyclerView = findViewById(R.id.recycicleproducto);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //adapter = new adaptardorProducto(datospublicos.listaproducto);
        //adapter.setClickListener(this);
        //recyclerView.setAdapter(adapter);


    }

    public void btactualizar_onclick(View view)
    {
        adapter = new adaptardorProducto(datospublicos.listaproducto);
        //adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }
}
