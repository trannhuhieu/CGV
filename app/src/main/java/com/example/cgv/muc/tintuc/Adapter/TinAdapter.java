package com.example.cgv.muc.tintuc.Adapter;

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
import com.example.cgv.muc.tintuc.tin.ChitietTin;

import java.util.ArrayList;

public class TinAdapter extends RecyclerView.Adapter<TinAdapter.PhimViewHolder>{
    private Context context;
    private ArrayList<TINTUC> tintucs;

    public TinAdapter(Context context, ArrayList<TINTUC> tintucs) {
        this.context = context;
        this.tintucs = tintucs;
    }

    @NonNull
    @Override
    public PhimViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tintuc, parent,false);
        return new PhimViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhimViewHolder holder, int position) {
        TINTUC tin = tintucs.get(position);
        holder.hinhtin.setImageResource(tin.getImgTin());
        holder.tentin.setText(tin.getTextTieude());
        holder.noidungtin.setText(tin.getTextNoidung());
    }

    @Override
    public int getItemCount() {
        if (tintucs != null)
            return tintucs.size();
        return 0;
    }

    public class PhimViewHolder extends RecyclerView.ViewHolder{

        private final ImageView hinhtin;
        private final TextView tentin, noidungtin;

        public PhimViewHolder(@NonNull View itemView) {
            super(itemView);
            hinhtin = itemView.findViewById(R.id.imgtin);
            tentin = itemView.findViewById(R.id.texttin);
            noidungtin = itemView.findViewById(R.id.textndtin);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    TINTUC tin = tintucs.get(position);
                    // Xử lý sự kiện nhấp vào trang tại vị trí position
//                    Intent intent = new Intent(position, ChitietPhim.class);
                    Intent intent = new Intent(view.getContext(), ChitietTin.class);
                    intent.putExtra("IMG", tin.getImgTin());
                    intent.putExtra("ND", tin.getTextNoidung());
                    intent.putExtra("TEN", tin.getTextTieude());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
}

