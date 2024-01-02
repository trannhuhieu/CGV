package com.example.cgv.muc.banner;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cgv.R;
import com.example.cgv.muc.phim.chitiet.ChitietPhim;
import com.example.cgv.muc.tintuc.Adapter.TINTUC;
import com.example.cgv.muc.tintuc.tin.ChitietTin;

import java.util.List;

public class SlideAdapter extends RecyclerView.Adapter<SlideAdapter.SlideViewHolder>{
    private Context context;
    private static List<SLIDE> slides;

    public SlideAdapter(Context context, List<SLIDE> slides) {
        this.context = context;
        this.slides = slides;
    }


    @NonNull
    @Override
    public SlideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_silde, parent,false);
        return new SlideViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SlideViewHolder holder, int position) {
        SLIDE slide = slides.get(position);
        if (slide == null)
            return;
        holder.slide.setImageResource(slide.getId_slide());
    }

    @Override
    public int getItemCount() {
        if (slides != null)
            return slides.size();
        return 0;
    }

    public static class SlideViewHolder extends RecyclerView.ViewHolder{

        private final ImageView slide;
        public SlideViewHolder(@NonNull View itemView) {
            super(itemView);
            slide = itemView.findViewById(R.id.item_slide);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    SLIDE slide = slides.get(position);
                    // Xử lý sự kiện nhấp vào trang tại vị trí position
                    Intent intent = new Intent(view.getContext(), ChitietTin.class);

                    intent.putExtra("IMG", slide.getId_slide());
//                    intent.putExtra("DE", tin.getTextNoidung());
//                    intent.putExtra("TEN", tin.getTextTieude());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
}
