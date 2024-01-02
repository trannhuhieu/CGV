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
import com.example.cgv.muc.phim.adapter.PHIM;
import com.example.cgv.muc.tintuc.tin.ChitietTin;
import com.example.cgv.muc.videos.All_Videos;
import com.example.cgv.muc.videos.VIDEO;
import com.example.cgv.muc.videos.VideosAdapter;

import java.util.ArrayList;

public class KenhCineAdapter extends RecyclerView.Adapter<KenhCineAdapter.KenhCineViewHolder>{

    private Context context;
    private ArrayList<KENHCINE> kenhcines;

    public KenhCineAdapter(Context context, ArrayList<KENHCINE> kenhcines) {
        this.context = context;
        this.kenhcines = kenhcines;
    }

    @NonNull
    @Override
    public KenhCineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tinnong, parent,false);
        return new KenhCineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KenhCineViewHolder holder, int position) {
        KENHCINE kenhcine = kenhcines.get(position);
        holder.hinh.setImageResource(kenhcine.getHinh());
        holder.tenvideo.setText(kenhcine.getTen());
    }

    @Override
    public int getItemCount() {
        if (kenhcines != null)
            return kenhcines.size();
        return 0;
    }

    public class KenhCineViewHolder extends RecyclerView.ViewHolder{

        private final ImageView hinh;
        private final TextView tenvideo;

        public KenhCineViewHolder(@NonNull View itemView) {
            super(itemView);
            hinh = itemView.findViewById(R.id.imgtinnong);
            tenvideo = itemView.findViewById(R.id.textndtinnong);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    KENHCINE kenhcine = kenhcines.get(position);
                    Intent intent = new Intent(view.getContext(), ChitietTin.class);
                    intent.putExtra("IMG", kenhcine.getHinh());
                    intent.putExtra("TEN", kenhcine.getTen());
                    view.getContext().startActivity(intent);

                }
            });
        }
    }
}
