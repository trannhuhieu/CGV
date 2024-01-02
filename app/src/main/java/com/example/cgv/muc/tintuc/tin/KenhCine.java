package com.example.cgv.muc.tintuc.tin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cgv.R;

public class KenhCine extends AppCompatActivity {

    ImageView hinh;
    TextView ten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kenh_cine);

        hinh = findViewById(R.id.imgkenh);
        ten = findViewById(R.id.textkenh);

        intiToolbar();

        int idPhim = getIntent().getIntExtra("ID_PHIM", 0);
        String tenPhim = getIntent().getStringExtra("TEN_PHIM");

        hinh.setImageResource(idPhim);
        ten.setText(tenPhim);
    }

    private void intiToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbarVideos);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.close);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}