package com.example.ejemploretrofit_java;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adaptardorProducto
        extends RecyclerView.Adapter<adaptardorProducto.Viewholder>

{
    ArrayList<producto> listaproducto;

    public adaptardorProducto(ArrayList<producto> listaproducto) {
        this.listaproducto = listaproducto;
    }

    @NonNull
    @Override
    public adaptardorProducto.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.itemrecycleproductos, parent, false);

        // Return a new holder instance

        Viewholder viewHolder = new Viewholder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull adaptardorProducto.Viewholder holder, int position)
    {
        producto pro = listaproducto.get(position);
        holder.tvnombre.setText(pro.getNombre());
        holder.tvcategoria.setText(pro.getCategoria());
        holder.tvprecio.setText(String.valueOf( pro.getPrecio()));

    }

    @Override
    public int getItemCount() {
        return listaproducto.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        public TextView tvnombre;
        public TextView tvprecio;
        public TextView tvcategoria;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            tvnombre = (TextView) itemView.findViewById(R.id.tvnombre);

            tvprecio = (TextView) itemView.findViewById(R.id.tvprecio);

            tvcategoria = (TextView) itemView.findViewById(R.id.tvcategoria);

        }

    }
}
