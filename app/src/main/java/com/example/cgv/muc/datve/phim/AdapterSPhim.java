package com.example.cgv.muc.datve.phim;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cgv.R;
import com.example.cgv.muc.datve.ChonGhe.ChonGhe;
import com.example.cgv.muc.phim.adapter.PHIM;
import com.example.cgv.muc.phim.adapter.PhimAdapter;
import com.example.cgv.muc.phim.chitiet.ChitietPhim;

import java.util.List;

public class AdapterSPhim extends RecyclerView.Adapter<AdapterSPhim.SPhimViewHolder>{

    private List<SUATPHIM> SPhim;
    public Context context;

    public AdapterSPhim(List<SUATPHIM> SPhim, Context context) {
        this.SPhim = SPhim;
        this.context = context;
    }

    @NonNull
    @Override
    public SPhimViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_suat, parent,false);
        return new SPhimViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SPhimViewHolder holder, int position) {
        SUATPHIM suat = SPhim.get(position);
        holder.bd.setText(suat.getStart());
        holder.kt.setText(suat.getEnd());
    }

    @Override
    public int getItemCount() {
        if (SPhim != null)
            return SPhim.size();
        return 0;
    }

    public class SPhimViewHolder extends RecyclerView.ViewHolder{

        private final TextView bd, kt;

        public SPhimViewHolder(@NonNull View itemView) {
            super(itemView);
            bd = itemView.findViewById(R.id.from);
            kt = itemView.findViewById(R.id.to);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    SUATPHIM sphim = SPhim.get(position);
                    // Xử lý sự kiện nhấp vào trang tại vị trí position
                    Intent intent = new Intent(view.getContext(), ChonGhe.class);
                    intent.putExtra("FROM", sphim.getStart());
                    intent.putExtra("TO", sphim.getEnd());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
}
