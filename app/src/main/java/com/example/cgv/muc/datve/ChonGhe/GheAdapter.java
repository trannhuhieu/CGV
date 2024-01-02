package com.example.cgv.muc.datve.ChonGhe;

import static com.example.cgv.R.drawable.chonghe;

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
import java.util.Collections;

public class GheAdapter extends RecyclerView.Adapter<GheAdapter.GheViewHolder>{

    private Context context;
    private ArrayList<GHE> ghes;

    public static final int TYPE1 = 0;
    public static final int TYPE2 = 1;

    public static ArrayList<Integer> danhsachchon = new ArrayList<Integer>();

    public static int thanhtien = 0;

    public GheAdapter(Context context, ArrayList<GHE> ghes) {
        this.context = context;
        this.ghes = ghes;
    }

    @Override
    public int getItemViewType(int position) {

        if (position <= 13 || position >= 42)
            return TYPE1;
        else
            return TYPE2;
    }

    @NonNull
    @Override
    public GheViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View studentView = null;

        switch (viewType)
        {
            case TYPE1:
                studentView =
                        inflater.inflate(R.layout.item_ghe,
                                parent, false);
                break;
            case TYPE2:
                studentView =
                        inflater.inflate(R.layout.item_ghev,
                                parent, false);
                break;
        }

        GheViewHolder viewHolder = new GheViewHolder(studentView);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull GheViewHolder holder, int position) {
        GHE ghe = ghes.get(position);

        holder.tenghe.setText(ghe.getSeat_type()+ghe.getNumber());
        holder.tt.setText(ghe.getNumber());

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            int sl = 0;
            int gheA = 100000;
            int gheV = 150000;

            @Override
            public void onClick(View v) {

                holder.tenghe.setBackgroundResource(chonghe);
                sl++;

                if (sl%2 == 0)
                {
                    if (position <= 13)
                    {
                        holder.tenghe.setBackgroundResource(R.color.nul);
                        GheAdapter.thanhtien -= gheA;
                    } else if ( position >= 42){
                        holder.tenghe.setBackgroundResource(R.color.nul);
                        GheAdapter.thanhtien -= gheA;
                    }
                    else {
                        holder.tenghe.setBackgroundResource(R.color.red);
                        GheAdapter.thanhtien -= gheV;
                    }
                    String textTT = "";
                    textTT += GheAdapter.thanhtien;
                    ChonGhe.gia.setText(textTT);

                    if(danhsachchon.size()>=1){
                        for (int i = danhsachchon.size()-1; i>=0; i--){
                            if (danhsachchon.get(i) == position+1)
                            {
                                danhsachchon.remove(i);
                                break;
                            }
                        }
                    }

                }else {

                    if (position <= 13)
                    {
                        GheAdapter.thanhtien += gheA;
                    }else if(position >= 42){
                        GheAdapter.thanhtien += gheA;
                    } else {
                        GheAdapter.thanhtien += gheV;
                    }
                    String textTT = "";
                    textTT += GheAdapter.thanhtien;
                    ChonGhe.gia.setText(textTT);

                    boolean ktra = true;
                    if (danhsachchon==null)
                    {
//                        danhsachchon.add(position+1);
                    }
                    else {
                        for (int i = 0; i<danhsachchon.size(); i++){
                            if (danhsachchon.get(i) == position+1)
                            {
                                ktra = false;
                            }
                        }
                        if (ktra){
                            danhsachchon.add(position+1);
                        }
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (ghes != null)
            return ghes.size();
        return 0;
    }

    public class GheViewHolder extends RecyclerView.ViewHolder{

        private final TextView tenghe, tt;

        public GheViewHolder(@NonNull View itemView) {
            super(itemView);

            tenghe = itemView.findViewById(R.id.ghe);
            tt = itemView.findViewById(R.id.tt);
        }
    }
}
