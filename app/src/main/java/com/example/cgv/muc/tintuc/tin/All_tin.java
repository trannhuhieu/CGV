package com.example.cgv.muc.tintuc.tin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cgv.MainActivity;
import com.example.cgv.R;
import com.example.cgv.muc.tintuc.Adapter.TINTUC;
import com.example.cgv.muc.tintuc.Adapter.TinAdapter;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class All_tin extends AppCompatActivity {

    DrawerLayout drawerLayout;
    RecyclerView rvalltin;
    private ArrayList<TINTUC> tintucs = new ArrayList<>();
    private TinAdapter tinAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tin);

        rvalltin = findViewById(R.id.recycler_alltin);
        drawerLayout = findViewById(R.id.drawer_layout);
        intiToolbar();

        tintucs = getListTin();
        tinAdapter = new TinAdapter(this, tintucs);
        rvalltin.setAdapter(tinAdapter);
        rvalltin.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        setNavigationView();

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
//                Intent intent = new Intent(ChitietPhim.this, MainActivity.class);
//                startActivity(intent);
                onBackPressed();
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

    private ArrayList<TINTUC> getListTin(){
        tintucs = new ArrayList<>();
        tintucs.add(new TINTUC(R.drawable.tin1, "Khảo sát hình tượng diễn viên Kiều Minh Tuấn trong phim mới", "v.v.v"));
        tintucs.add(new TINTUC(R.drawable.tin2, "Chính thức: Thời gian và địa điểm nhận quà VVIP2023", "v.v.v"));
        tintucs.add(new TINTUC(R.drawable.tin3, "Tháng 6 vui vẻ, chỉ 14k 1 vé phim hay", "v.v.v"));
        tintucs.add(new TINTUC(R.drawable.tin4, "Chương trình ưu đãi dành cho chủ thẻ OCB tại CGV", "v.v.v"));
        tintucs.add(new TINTUC(R.drawable.tin5, "[CERAVE X CGV] CERAVE có CERAMIDES - Khóa ẩm làn da", "v.v.v"));
        tintucs.add(new TINTUC(R.drawable.tin6, "Chào hè với giá vé CGV cực hay", "v.v.v"));
        tintucs.add(new TINTUC(R.drawable.tin7, "Miễn phí UPSIZE bắp nước, thanh toán ZALOPAY", "v.v.v"));
        tintucs.add(new TINTUC(R.drawable.tin8, "Chương trình ưu dãi chỉ 135k cho 2 vé phim", "v.v.v"));
        return tintucs;
    }

    private void intiToolbar(){
        Toolbar toolbarTin = findViewById(R.id.toolbarTin);

        setSupportActionBar(toolbarTin);
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
//                Toast.makeText(getApplication(),"Menu", Toast.LENGTH_SHORT).show();
                drawerLayout.openDrawer(GravityCompat.END);
                break;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}