package com.azhardevelop.example.com.paketwisataapi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.azhardevelop.example.com.paketwisataapi.retro.ApiServicePaket;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PaketAdapter extends RecyclerView.Adapter<PaketAdapter.PaketHolder> {
    Context context;
    LayoutInflater inflater;
    private List<ApiServicePaket> paketList;
    private String URL_GAMBAR = "https://pembuatanprogram.000webhostapp.com/img/";

    public PaketAdapter(MainActivity activity, List<ApiServicePaket> body) {
        this.context = activity;
        this.paketList = body;
        inflater = LayoutInflater.from(activity);
    }

    @NonNull
    @Override
    public PaketHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.item_paket, viewGroup, false);
        PaketHolder holder = new PaketHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PaketHolder paketHolder, int position) {
        paketHolder.txtName.setText(paketList.get(position).getName());
        paketHolder.txtPrice.setText(paketList.get(position).getHarga());
        Picasso
                .with(context)
                .load(URL_GAMBAR + paketList.get(position).getGambar())
                .error(R.drawable.ic_launcher_background)
                .into(paketHolder.imgPack);

    }

    @Override
    public int getItemCount() {
        return paketList.size();
    }

    public class PaketHolder extends RecyclerView.ViewHolder {
        View packView;
        ImageView imgPack;
        TextView txtName, txtPrice;

        public PaketHolder(@NonNull View itemView) {
            super(itemView);
            packView = itemView;
            imgPack = itemView.findViewById(R.id.imgPack);
            txtName = itemView.findViewById(R.id.packName);
            txtPrice = itemView.findViewById(R.id.pricePack);
        }
    }
}
