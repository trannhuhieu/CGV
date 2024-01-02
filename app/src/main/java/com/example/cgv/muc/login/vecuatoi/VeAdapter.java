package com.example.cgv.muc.login.vecuatoi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cgv.R;
import com.example.cgv.muc.thanhtoan.ChitietThanhtoan;

import java.util.ArrayList;

public class VeAdapter extends RecyclerView.Adapter<VeAdapter.VeViewHolder>{

    private Context context;
    private ArrayList<VE> ves;

    public VeAdapter(Context context, ArrayList<VE> ves) {
        this.context = context;
        this.ves = ves;
    }

    @NonNull
    @Override
    public VeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vecuatoi, parent, false);
        return new VeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VeViewHolder holder, int position) {
        VE ve = ves.get(position);
        holder.tenphim.setText(ve.getTenphim());
        holder.thoigiandat.setText(ve.getThoigiandat());
        holder.ngaydat.setText(ve.getNgaydat());
        holder.bd.setText(ve.getBd());
        holder.kt.setText(ve.getKt());
        holder.ghe.setText(ve.getGhe());
        holder.tong.setText(ve.getTong());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ChitietThanhtoan.class);
                intent.putExtra("TEN", ve.getTenphim());
                intent.putExtra("NGAY", ve.getNgaydat());
                intent.putExtra("FROM", ve.getBd());
                intent.putExtra("TO", ve.getKt());
                intent.putExtra("GHE", ve.getGhe());
                intent.putExtra("TIEN", ve.getTong());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ves.size();
    }

    public class VeViewHolder extends RecyclerView.ViewHolder{

        private final TextView tenphim, ngaydat, bd, kt, ghe, tong, thoigiandat;

        public VeViewHolder(@NonNull View itemView) {
            super(itemView);

            tenphim = itemView.findViewById(R.id.tenve);
            thoigiandat = itemView.findViewById(R.id.time_ve);

            ngaydat = itemView.findViewById(R.id.ngay_ve);
            bd = itemView.findViewById(R.id.bd_ve);
            kt = itemView.findViewById(R.id.kt_ve);
            ghe = itemView.findViewById(R.id.ghe_ve);
            tong = itemView.findViewById(R.id.tong_ve);
        }
    }
}
