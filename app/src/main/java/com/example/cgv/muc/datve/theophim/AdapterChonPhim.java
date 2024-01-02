package com.example.cgv.muc.datve.theophim;

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
import com.example.cgv.muc.datve.phim.Datve_phim;
import com.example.cgv.muc.phim.adapter.PHIM;
import com.example.cgv.muc.tintuc.tin.ChitietTin;

import java.util.ArrayList;

public class AdapterChonPhim extends RecyclerView.Adapter<AdapterChonPhim.ChonPhimViewHolder>{
    private Context context;
    private ArrayList<PHIM> phims;

    public AdapterChonPhim(Context context, ArrayList<PHIM> phims) {
        this.context = context;
        this.phims = phims;
    }

    @NonNull
    @Override
    public ChonPhimViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chonphim, parent,false);
        return new ChonPhimViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChonPhimViewHolder holder, int position) {
        PHIM tin = phims.get(position);
        holder.hinhphim.setImageResource(tin.getId());
        holder.tenphim.setText(tin.getTen());
        holder.thoigian.setText(tin.getThoigian());
    }

    @Override
    public int getItemCount() {
        if (phims != null)
            return phims.size();
        return 0;
    }

    public class ChonPhimViewHolder extends RecyclerView.ViewHolder{

        private final ImageView hinhphim;
        private final TextView tenphim, thoigian;

        public ChonPhimViewHolder(@NonNull View itemView) {
            super(itemView);
            hinhphim = itemView.findViewById(R.id.imgcp);
            tenphim = itemView.findViewById(R.id.tencp);
            thoigian = itemView.findViewById(R.id.tgcp);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    PHIM phim = phims.get(position);
                    // Xử lý sự kiện nhấp vào trang tại vị trí position
                    Intent intent = new Intent(view.getContext(), Datve_phim.class);
                    intent.putExtra("HINH", phim.getId());
                    intent.putExtra("TEN", phim.getTen());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
}
