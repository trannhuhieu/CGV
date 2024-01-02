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

public class TinnongAdapter extends RecyclerView.Adapter<TinnongAdapter.TinnongViewHolder>{
    private Context context;
    private ArrayList<TINTUC> tintucs;

    public TinnongAdapter(Context context, ArrayList<TINTUC> tintucs) {
        this.context = context;
        this.tintucs = tintucs;
    }

    @NonNull
    @Override
    public TinnongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tinnong, parent,false);
        return new TinnongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TinnongViewHolder holder, int position) {
        TINTUC tinnong = tintucs.get(position);
        holder.hinhtin.setImageResource(tinnong.getImgTin());
        holder.tentin.setText(tinnong.getTextTieude());
    }

    @Override
    public int getItemCount() {
        if (tintucs != null)
            return tintucs.size();
        return 0;
    }

    public class TinnongViewHolder extends RecyclerView.ViewHolder{

        private final ImageView hinhtin;
        private final TextView tentin;

        public TinnongViewHolder(@NonNull View itemView) {
            super(itemView);
            hinhtin = itemView.findViewById(R.id.imgtinnong);
            tentin = itemView.findViewById(R.id.textndtinnong);
//            noidungtin = itemView.findViewById(R.id.textndtin);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    TINTUC tin = tintucs.get(position);
                    // Xử lý sự kiện nhấp vào trang tại vị trí position
                    Intent intent = new Intent(view.getContext(), ChitietTin.class);
                    intent.putExtra("IMG", tin.getImgTin());
                    intent.putExtra("DE", tin.getTextNoidung());
                    intent.putExtra("TEN", tin.getTextTieude());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
}
