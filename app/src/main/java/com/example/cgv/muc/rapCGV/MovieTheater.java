package com.example.cgv.muc.rapCGV;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.cgv.R;

import java.util.ArrayList;

public class MovieTheater extends AppCompatActivity {

    RecyclerView rv_movie;

    ArrayList<THEATER_LOCAL> theater_locals = new ArrayList<>();
    TheaterAdapter theaterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_theater);

        rv_movie = findViewById(R.id.rv_goiy_moives);

        intiToolbar();

        theater_locals.add(new THEATER_LOCAL( "Aeon Long Biên","10 km"));
        theater_locals.add(new THEATER_LOCAL("Giga Mall Thủ Đức" ,"10 km"));
        theater_locals.add(new THEATER_LOCAL( "Saigonres Nguyễn Xí","10 km"));
        theater_locals.add(new THEATER_LOCAL( "Thảo Điền Peart","10 km"));
        theater_locals.add(new THEATER_LOCAL( "Vincom Thủ Đức","10 km"));
        theater_locals.add(new THEATER_LOCAL("Pearl Plaza" ,"10 km"));

        theaterAdapter = new TheaterAdapter(this, theater_locals);
        rv_movie.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rv_movie.setAdapter(theaterAdapter);
        DividerItemDecoration dividerHorizontal = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rv_movie.addItemDecoration(dividerHorizontal);
    }

    private void intiToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbarrapCGV);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_phim, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menuPhim:
//                drawerLayout.openDrawer(GravityCompat.END);
                break;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}