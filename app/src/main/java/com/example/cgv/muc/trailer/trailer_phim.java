package com.example.cgv.muc.trailer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.cgv.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class trailer_phim extends AppCompatActivity {

    YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailer_phim);

        String ten = getIntent().getStringExtra("ten");

        youTubePlayerView = findViewById(R.id.youtube_player_view);
//        getLifecycle().addObserver(youTubePlayerView);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                super.onReady(youTubePlayer);
//                String videoId = "Wt0y8IH63jg";
                String currentTopic = String.valueOf(ten);
                String videoId = getVideoIdForTopic(currentTopic);
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

    }

    private String getVideoIdForTopic(String currentTopic) {
        switch (currentTopic) {
            case "Transformers: quái thú trỗi dậy":
                return "lRBA1AKyUaI";
            case "Người nhện: Du hành vũ trụ nhện":
                return "Wt0y8IH63jg";
            case "Phim điện ảnh Doremon: Nobita và vùng đất bí ẩn":
                return "JvrF88ym3_0";
            case "Fast and Furious X":
                return "JSE9vhCuxs8";
            case "Hoon payon: Bùa hình nhân":
                return "IQxKXtge6r8";
            case "flash":
                return "E7_YI4z6SLM&t=55s";
            case "Mavka: thần thoại rừng xanh":
                return "1Px8mlgaEZg&t=1s";

            default:
                return "iA9iqygq11Q";
        }
    }
}