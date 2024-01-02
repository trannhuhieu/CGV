package com.example.cgv.muc.videos;

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

import java.util.ArrayList;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.VideosViewHolder>{

    private Context context;
    private ArrayList<VIDEO> videos;

    public VideosAdapter(Context context, ArrayList<VIDEO> videos) {
        this.context = context;
        this.videos = videos;
    }

    @NonNull
    @Override
    public VideosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_videos, parent,false);
        return new VideosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideosViewHolder holder, int position) {
        VIDEO video = videos.get(position);
        holder.hinh.setImageResource(video.getHinh());
        holder.tenvideo.setText(video.getTen());
    }

    @Override
    public int getItemCount() {
        if (videos != null)
            return videos.size();
        return 0;
    }

    public class VideosViewHolder extends RecyclerView.ViewHolder{

        private final ImageView hinh;
        private final TextView tenvideo;

        public VideosViewHolder(@NonNull View itemView) {
            super(itemView);
            hinh = itemView.findViewById(R.id.imgvideo);
            tenvideo = itemView.findViewById(R.id.tenvideo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), All_Videos.class);
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
}
