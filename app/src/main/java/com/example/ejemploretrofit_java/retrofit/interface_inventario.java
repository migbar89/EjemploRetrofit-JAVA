package com.example.ejemploretrofit_java.retrofit;

import com.example.ejemploretrofit_java.producto;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface interface_inventario
{
    @GET("webservice_inventario/consultaproductos.php")
    Call<ArrayList<producto>> consultaproductos();

    @FormUrlEncoded
    @POST("webservice_inventario/insertarproducto.php")
    Call<ResponseBody> InsertarCuota(@Field("nombre") String nombre,
                                     @Field("precio") float precio,
                                     @Field("categoria") String categoria);

}
