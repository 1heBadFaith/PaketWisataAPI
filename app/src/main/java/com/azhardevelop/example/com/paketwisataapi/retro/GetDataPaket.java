package com.azhardevelop.example.com.paketwisataapi.retro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataPaket {
    @GET("produk.php")
    Call<List<ApiServicePaket>> getAllPaket();
}
