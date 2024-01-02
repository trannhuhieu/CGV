package com.example.cgv.muc.goi;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cgv.R;


import java.util.ArrayList;


public class GoiAdapter extends RecyclerView.Adapter<GoiAdapter.GoiViewHolder>{

    private final ArrayList<GOI> goidata;
//    public final Context context;

    public GoiAdapter(ArrayList<GOI> goidata) {
        this.goidata = goidata;
//        this.context = context;
    }

    @NonNull
    @Override
    public GoiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_goi, parent,false);
        return new GoiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GoiViewHolder holder, int position) {
        GOI goi = goidata.get(position);
        holder.hinhgoi.setImageResource(goi.getHinh());
        holder.tengoi.setText(goi.getTen());
    }

    @Override
    public int getItemCount() {
        if (goidata != null)
            return goidata.size();
        return 0;
    }

    public class GoiViewHolder extends RecyclerView.ViewHolder{

        private final ImageView hinhgoi;
        private final TextView tengoi;

        public GoiViewHolder(@NonNull View itemView) {
            super(itemView);
            hinhgoi = itemView.findViewById(R.id.hinhgoi);
            tengoi = itemView.findViewById(R.id.tengoi);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    GOI goi = goidata.get(position);
                    // Xử lý sự kiện nhấp vào trang tại vị trí position
                    Toast.makeText(itemView.getContext(), ""+goi.getTen(), Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(view.getContext(), ChitietPhim.class);
//                    intent.putExtra("ID_PHIM", phim.getId());
//                    intent.putExtra("TEN_PHIM", phim.getTen());
//                    intent.putExtra("THOI_GIAN", phim.getThoigian());
//                    intent.putExtra("NOIDUNG", phim.getNoidung());
//                    intent.putExtra("KIEMDUYET", phim.getKiemduyet());
//                    intent.putExtra("THELOAI", phim.getTheloai());
//                    intent.putExtra("NGONNGU", phim.getNgonngu());
//                    view.getContext().startActivity(intent);
                }
            });
        }
    }
}
