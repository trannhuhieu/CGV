package com.example.cgv.muc.login.vecuatoi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.cgv.R;
import com.example.cgv.muc.thanhtoan.ChitietThanhtoan;

import java.util.ArrayList;

public class VeCuaToi extends AppCompatActivity {

    TextView kodl;
    RecyclerView rv_vecuatoi;
//    ArrayList<VE> ves = new ArrayList<>();
    VeAdapter veAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ve_cua_toi);

        rv_vecuatoi = findViewById(R.id.rv_vecuatoi);
        kodl = findViewById(R.id.khongcodl);

        intiToolbar();

        veAdapter = new VeAdapter(this, ChitietThanhtoan.ves);
        rv_vecuatoi.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rv_vecuatoi.setAdapter(veAdapter);

//        VE ve = ves.get(0);
        if (ChitietThanhtoan.ten_ve==null){
            rv_vecuatoi.setVisibility(View.GONE);
        }else {
            kodl.setVisibility(View.INVISIBLE);
        }
    }
    private void intiToolbar(){
        Toolbar toolbartt = findViewById(R.id.toolbarvecuatoi);

        setSupportActionBar(toolbartt);
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