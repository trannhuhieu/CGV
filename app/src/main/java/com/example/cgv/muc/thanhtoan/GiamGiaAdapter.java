package com.example.cgv.muc.thanhtoan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cgv.R;

import java.util.ArrayList;

public class GiamGiaAdapter extends RecyclerView.Adapter<GiamGiaAdapter.GiamGiaViewHolder>{

    private Context context;
    private ArrayList<GIAMGIA> giamgias;

    public GiamGiaAdapter(Context context, ArrayList<GIAMGIA> giamgias) {
        this.context = context;
        this.giamgias = giamgias;
    }

    @NonNull
    @Override
    public GiamGiaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ptgg, parent, false);
        return new GiamGiaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GiamGiaViewHolder holder, int position) {
        GIAMGIA giamgia = giamgias.get(position);
        holder.tenmagiam.setText(giamgia.getTenmagiam());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context.getApplicationContext(), ""+giamgia.getTenmagiam(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return giamgias.size();
    }

    public class GiamGiaViewHolder extends RecyclerView.ViewHolder{

        private final TextView tenmagiam;

        public GiamGiaViewHolder(@NonNull View itemView) {
            super(itemView);

            tenmagiam = itemView.findViewById(R.id.tengiamgia);
        }
    }
}
