package com.example.cgv.muc.tintuc.tin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cgv.MainActivity;
import com.example.cgv.R;
import com.google.android.material.navigation.NavigationView;

public class ChitietTin extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView img;
    TextView ten, nd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet_tin);

        drawerLayout = findViewById(R.id.drawer_layout);
        img = findViewById(R.id.hinhcttin);
        ten = findViewById(R.id.tencttin);
        nd = findViewById(R.id.ndcttin);

        intiToolbar();

        int idTIN = getIntent().getIntExtra("IMG", 0);
        String tenTin = getIntent().getStringExtra("TEN");
        String noidung = getIntent().getStringExtra("ND");

        img.setImageResource(idTIN);
        ten.setText(tenTin);
        nd.setText(noidung);

        setNavigationView();
    }

    private void intiToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbarctTin);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);
    }

    public void setNavigationView(){
        NavigationView navigationView = findViewById(R.id.nav_view);
        View headView = navigationView.getHeaderView(0);

        LinearLayout tc, tv, rcgv, rdb, tm, ve, dud, btndangxuat;
        TextView user;

        user = headView.findViewById(R.id.user);
        tc = headView.findViewById(R.id.trangchu);
        tv = headView.findViewById(R.id.thanhvien);
        rcgv = headView.findViewById(R.id.rapcgv);
        rdb = headView.findViewById(R.id.rapdb);
        tm = headView.findViewById(R.id.tinmoi);
        ve = headView.findViewById(R.id.ve);
        dud = headView.findViewById(R.id.doiud);
        btndangxuat = headView.findViewById(R.id.btndangxuat);
        if (MainActivity.isHasUser)
        {
            user.setText(MainActivity.mUser.getUsername());

            btndangxuat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    MainActivity.isHasUser = false;
                    startActivity(intent);
                }
            });
        }else
        {
            btndangxuat.setVisibility(View.INVISIBLE);
        }

        tc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Trang chủ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ChitietTin.this, MainActivity.class);
                startActivity(intent);

            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Thành viên", Toast.LENGTH_SHORT).show();
            }
        });
        rcgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Rạp CGV", Toast.LENGTH_SHORT).show();
            }
        });
        rdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Rạp đặc biệt", Toast.LENGTH_SHORT).show();
            }
        });
        tm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Tin mới & Ưu đãi", Toast.LENGTH_SHORT).show();
            }
        });
        ve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Vé của tôi", Toast.LENGTH_SHORT).show();
            }
        });
        dud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Đổi ưu đãi", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_phim, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menuPhim:
//                Toast.makeText(getApplication(),"Menu", Toast.LENGTH_SHORT).show();
                drawerLayout.openDrawer(GravityCompat.END);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}