package com.example.cgv.muc.phim.adapter;

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
import com.example.cgv.muc.phim.chitiet.ChitietPhim;

import java.util.List;

public class PhimAdapter extends RecyclerView.Adapter<PhimAdapter.PhimViewHolder>{

    private final List<PHIM> Phim;
    public final Context context;

    public PhimAdapter(List<PHIM> phim, Context context) {
        Phim = phim;
        this.context = context;
    }

    public PHIM getData(int position) {

        return Phim.get(position);
    }


    @NonNull
    @Override
    public PhimViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phim, parent,false);
        return new PhimViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhimViewHolder holder, int position) {
        PHIM phim = Phim.get(position);

        holder.phim.setImageResource(phim.getId());
        holder.ten.setText(phim.getTen());
        holder.thoigian.setText(phim.getThoigian());
        holder.noidung.setText(phim.getNoidung());
        holder.kiemduyet.setText(phim.getKiemduyet());
        holder.theloai.setText(phim.getTheloai());
        holder.ngonngu.setText(phim.getNgonngu());
    }

    @Override
    public int getItemCount() {
        if (Phim != null)
            return Phim.size();
        return 0;
    }

    public class PhimViewHolder extends RecyclerView.ViewHolder{

        private final ImageView phim;
        private final TextView ten;
        private final TextView thoigian, noidung, kiemduyet, theloai, ngonngu;

        public PhimViewHolder(@NonNull View itemView) {
            super(itemView);
            phim = itemView.findViewById(R.id.item_phim);
            ten = itemView.findViewById(R.id.tenphim);
            thoigian = itemView.findViewById(R.id.thoigian);
            noidung = itemView.findViewById(R.id.itemnd);
            kiemduyet = itemView.findViewById(R.id.itemkd);
            theloai = itemView.findViewById(R.id.itemtl);
            ngonngu = itemView.findViewById(R.id.itemnn);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    PHIM phim = Phim.get(position);
                    // Xử lý sự kiện nhấp vào trang tại vị trí position
                    Intent intent = new Intent(view.getContext(), ChitietPhim.class);
                    intent.putExtra("ID_PHIM", phim.getId());
                    intent.putExtra("TEN_PHIM", phim.getTen());
                    intent.putExtra("THOI_GIAN", phim.getThoigian());
                    intent.putExtra("NOIDUNG", phim.getNoidung());
                    intent.putExtra("KIEMDUYET", phim.getKiemduyet());
                    intent.putExtra("THELOAI", phim.getTheloai());
                    intent.putExtra("NGONNGU", phim.getNgonngu());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
}
