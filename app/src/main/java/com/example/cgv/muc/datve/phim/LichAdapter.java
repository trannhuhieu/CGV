package com.example.cgv.muc.datve.phim;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cgv.R;
import java.util.ArrayList;

public class LichAdapter extends RecyclerView.Adapter<LichAdapter.LichViewHolder>{
    private Context context;
    private ArrayList<LICH> liches;

    public LichAdapter(Context context, ArrayList<LICH> liches) {
        this.context = context;
        this.liches = liches;
    }

    @NonNull
    @Override
    public LichViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lich, parent,false);
        return new LichViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LichViewHolder holder, int position) {
        LICH lich = liches.get(position);
        holder.cn.setText(lich.getChuNhat());
        holder.t2.setText(lich.getThu2());
        holder.t3.setText(lich.getThu3());
        holder.t4.setText(lich.getThu4());
        holder.t5.setText(lich.getThu5());
        holder.t7.setText(lich.getThu6());
        holder.t7.setText(lich.getThu7());
    }


    @Override
    public int getItemCount() {
        if (liches != null)
            return liches.size();
        return 0;
    }


    public class LichViewHolder extends RecyclerView.ViewHolder{

        private final TextView cn, t2, t3, t4, t5, t6, t7;

        public LichViewHolder(@NonNull View itemView) {
            super(itemView);
            cn = itemView.findViewById(R.id.ng1);
            t2 = itemView.findViewById(R.id.ng2);
            t3 = itemView.findViewById(R.id.ng3);
            t4 = itemView.findViewById(R.id.ng4);
            t5 = itemView.findViewById(R.id.ng5);
            t6 = itemView.findViewById(R.id.ng6);
            t7 = itemView.findViewById(R.id.ng7);

        }
    }
}
