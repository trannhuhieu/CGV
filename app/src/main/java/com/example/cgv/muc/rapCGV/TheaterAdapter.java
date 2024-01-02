package com.example.cgv.muc.rapCGV;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cgv.R;
import com.example.cgv.muc.datve.ChonGhe.GHE;

import java.util.ArrayList;

public class TheaterAdapter extends RecyclerView.Adapter<TheaterAdapter.TheaterViewHolder> {

    private Context context;
    private ArrayList<THEATER_LOCAL> theater_locals;

    public TheaterAdapter(Context context, ArrayList<THEATER_LOCAL> theater_locals) {
        this.context = context;
        this.theater_locals = theater_locals;
    }

    @NonNull
    @Override
    public TheaterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie_theater, null);
        return new TheaterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TheaterViewHolder holder, int position) {
        THEATER_LOCAL theater_local = theater_locals.get(position);
        holder.name.setText(theater_local.getName());
    }

    @Override
    public int getItemCount() {
        return theater_locals.size();
    }

    public class TheaterViewHolder extends RecyclerView.ViewHolder{

        private final TextView name;

        public TheaterViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tv_name_theater);

        }
    }
}
