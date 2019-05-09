package com.azhardevelop.example.com.paketwisataapi.retro;

import com.google.gson.annotations.SerializedName;

public class ApiServicePaket {
    @SerializedName("judul")
    private String name;

    @SerializedName("gambar")
    private String gambar;

    @SerializedName("harga")
    private String harga;


    public ApiServicePaket(String name, String gambar, String harga) {
        this.name = name;
        this.gambar = gambar;
        this.harga = harga;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
