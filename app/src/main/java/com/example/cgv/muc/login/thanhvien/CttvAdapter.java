package com.example.cgv.muc.login.thanhvien;

import android.content.Context;
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
import com.example.cgv.muc.datve.ChonGhe.ChonGhe;
import com.example.cgv.muc.datve.ChonGhe.GHE;
import com.example.cgv.muc.login.thanhvien.chitiettv.CoinCGV;
import com.example.cgv.muc.login.thanhvien.chitiettv.ThongTinTK;

import java.util.ArrayList;

public class CttvAdapter extends RecyclerView.Adapter<CttvAdapter.CttvViewHolder>{

    private Context context;
    private ArrayList<CTTV> cttvs;

    public CttvAdapter(Context context, ArrayList<CTTV> cttvs) {
        this.context = context;
        this.cttvs = cttvs;
    }

    @NonNull
    @Override
    public CttvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cttv, parent,false);
        return new CttvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CttvViewHolder holder, int position) {
        CTTV cttv = cttvs.get(position);
        holder.hinhct.setImageResource(cttv.getHinhcttv());
        holder.tenct.setText(cttv.getTencttv());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(v.getContext(), ""+cttv.getTencttv(), Toast.LENGTH_SHORT).show();
                int id = position;
                switch (id){
                    case 0:
                        Intent intenttt = new Intent(v.getContext(), ThongTinTK.class);
                        v.getContext().startActivity(intenttt);
                        break;
                    case 1:

                        break;
                    case 2:
                        break;
                    case 3:

                        break;
                    case 4:
                        Intent intentcont = new Intent(v.getContext(), CoinCGV.class);
                        v.getContext().startActivity(intentcont);
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (cttvs != null)
            return cttvs.size();
        return 0;
    }

    public class CttvViewHolder extends RecyclerView.ViewHolder{

        ImageView hinhct;
        TextView tenct;

        public CttvViewHolder(@NonNull View itemView) {
            super(itemView);

            hinhct = itemView.findViewById(R.id.img_rvThanhvien_display);
            tenct = itemView.findViewById(R.id.tv_Thanhvien_display);

        }
    }
}

