package com.example.ejemploretrofit_java.retrofit;

import com.example.ejemploretrofit_java.producto;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface interface_inventario
{
    @GET("webservice_inventario/consultaproductos.php")
    Call<ArrayList<producto>> consultaproductos();
}
