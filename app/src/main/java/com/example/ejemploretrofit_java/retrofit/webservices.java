package com.example.ejemploretrofit_java.retrofit;

import android.content.Context;
import android.widget.Toast;

import com.example.ejemploretrofit_java.datospublicos;
import com.example.ejemploretrofit_java.producto;
import com.example.ejemploretrofit_java.retrofit.interface_inventario;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class webservices
{
    Context context;
    Retrofit retrofit;

    public webservices(Context context) {
        this.context = context;
        Toast.makeText(context,"Creando objeto retrofit",Toast.LENGTH_SHORT).show();

        retrofit =new Retrofit.Builder().baseUrl("http://192.168.1.14")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public void insertar_producto(producto pro)
    {
        interface_inventario interfaz =  retrofit.create(interface_inventario.class);
        Call<ResponseBody> callproductos=interfaz.InsertarCuota(pro.getNombre(),pro.getPrecio(),pro.getCategoria());
        callproductos.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.code()==200)
                {
                    Toast.makeText(context,"Cuota Insertada Correctamente",Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void consultaproductos()
    {
        Toast.makeText(context,"Cargando Datos",Toast.LENGTH_SHORT).show();
        final ArrayList<producto> lista=new ArrayList<producto>();

        interface_inventario interfaz =  retrofit.create(interface_inventario.class);

        Call<ArrayList<producto>> listaproductos=interfaz.consultaproductos();

        listaproductos.enqueue(new Callback<ArrayList<producto>>() {
            @Override
            public void onResponse(Call<ArrayList<producto>> call, Response<ArrayList<producto>> response)
            {
                if(response.code()==200)
                {
                    Toast.makeText(context,"Datos Obtenidos="+String.valueOf(response.body().size()),Toast.LENGTH_SHORT).show();
                    for(int i=0;i<response.body().size();i++)
                    {
                        producto p=response.body().get(i);
                        lista.add(p);

                    }

                    datospublicos.listaproducto=lista;
                    Toast.makeText(context,"Datos Cargados",Toast.LENGTH_SHORT).show();

                }


            }

            @Override
            public void onFailure(Call<ArrayList<producto>> call, Throwable t)
            {
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_SHORT).show();


            }
        });
    }


}
