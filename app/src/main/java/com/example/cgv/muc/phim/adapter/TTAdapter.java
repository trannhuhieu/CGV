package com.example.cgv.muc.phim.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cgv.R;

import java.util.ArrayList;


public class TTAdapter extends RecyclerView.Adapter<TTAdapter.TTPhimViewHolder>{

    private final ArrayList<PHIM> Phim;
    public final Context context;

    public TTAdapter(ArrayList<PHIM> phim, Context context) {
        Phim = phim;
        this.context = context;
    }

    @NonNull
    @Override
    public TTPhimViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ttphim, parent,false);
        return new TTPhimViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TTPhimViewHolder holder, int position) {
        PHIM phim = Phim.get(position);
//        if (phim == null)
//            return;
        holder.ten.setText(phim.getTen());
        holder.thoigian.setText(phim.getThoigian());
    }

    @Override
    public int getItemCount() {
        if (Phim != null)
            return Phim.size();
        return 0;
    }

    public class TTPhimViewHolder extends RecyclerView.ViewHolder{

        private final TextView ten;
        private final TextView thoigian;

        public TTPhimViewHolder(@NonNull View itemView) {
            super(itemView);

            ten = itemView.findViewById(R.id.item_tenphim);
            thoigian = itemView.findViewById(R.id.item_thoigian);
        }
    }
}

