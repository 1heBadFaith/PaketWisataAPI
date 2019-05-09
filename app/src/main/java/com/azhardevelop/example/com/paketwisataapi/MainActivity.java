package com.azhardevelop.example.com.paketwisataapi;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.azhardevelop.example.com.paketwisataapi.retro.ApiServicePaket;
import com.azhardevelop.example.com.paketwisataapi.retro.GetDataPaket;
import com.azhardevelop.example.com.paketwisataapi.retro.PaketApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvData;
    ProgressDialog dialog;
    private PaketAdapter paketAdapter;
    private GridLayoutManager grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new ProgressDialog(MainActivity.this);
        dialog.setMessage("Load Data Paket....");
        dialog.setTitle("Loading..");
        dialog.show();

        GetDataPaket dataPaket = PaketApi.getRetrofit().create(GetDataPaket.class);
        Call<List<ApiServicePaket>> listCall = dataPaket.getAllPaket();
        listCall.enqueue(new Callback<List<ApiServicePaket>>() {
            @Override
            public void onResponse(Call<List<ApiServicePaket>> call, Response<List<ApiServicePaket>> response) {
                dialog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<ApiServicePaket>> call, Throwable t) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Tau Ah...Coba Lagi Dong!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataList(List<ApiServicePaket> body) {
        rvData = findViewById(R.id.listData);
        paketAdapter = new PaketAdapter(this, body);
        grid = new GridLayoutManager(this, 2);
        grid.setOrientation(LinearLayoutManager.VERTICAL);

        rvData.setLayoutManager(grid);
        rvData.setAdapter(paketAdapter);
    }
}
