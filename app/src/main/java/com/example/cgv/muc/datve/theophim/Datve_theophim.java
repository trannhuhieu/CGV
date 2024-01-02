package com.example.cgv.muc.datve.theophim;

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
import com.example.cgv.muc.phim.adapter.PHIM;
import com.example.cgv.muc.tintuc.Adapter.TINTUC;
import com.example.cgv.muc.tintuc.Adapter.TinAdapter;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class Datve_theophim extends AppCompatActivity {

    DrawerLayout drawerLayout;
    RecyclerView rv_cp;
    private ArrayList<PHIM> phims = new ArrayList<>();
    private AdapterChonPhim adapterChonPhim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datve_theophim);

        rv_cp = findViewById(R.id.recycler_dvtheophim);
        drawerLayout = findViewById(R.id.drawer_layout);
        intiToolbar();
        setNavigationView();

        phims = (ArrayList<PHIM>) getListPhim();
        adapterChonPhim = new AdapterChonPhim(this, phims);
        rv_cp.setAdapter(adapterChonPhim);
        rv_cp.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
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

    public List<PHIM> getListPhim(){
        phims = new ArrayList<>();
        phims.add(new PHIM(R.drawable.phim1, "Transformers: quái thú trỗi dậy", "01thg 6 2023 2giờ 20phút ", "Spiderman", "13+", "Hành động", "Tiếng Anh - Phụ đề tiếng Việt; Lồng Tiếng"));
        phims.add(new PHIM(R.drawable.nen5, "Người nhện: Du hành vũ trụ nhện", "01thg 6 2023 2giờ 20phút ", "Spiderman", "13+", "Hành động", "Tiếng Anh - Phụ đề tiếng Việt; Lồng Tiếng"));
        phims.add(new PHIM(R.drawable.nen2, "Phim điện ảnh Doremon: Nobita và vùng đất bí ẩn", "26thg 05 2023 1giờ 48phút ", "Doremon", "13+", "Hành động", "Tiếng Anh - Phụ đề tiếng Việt; Lồng Tiếng"));
        phims.add(new PHIM(R.drawable.phim3, "Fast and Furious X", "19thg 05 2023 2giờ 22phút ", "Fast and Furious", "13+", "Hành động", "Tiếng Anh - Phụ đề tiếng Việt; Lồng Tiếng"));
        phims.add(new PHIM(R.drawable.phim4, "Hoon payon: Bùa hình nhân", " 19thg 05 2023 2giờ 22phút", "Fast and Furious", "13+", "Hành động", "Tiếng Anh - Phụ đề tiếng Việt; Lồng Tiếng"));
        phims.add(new PHIM(R.drawable.nen2, "Phim điện ảnh Doremon: Nobita và vùng đất bí ẩn", " 26thg 05 2023 1giờ 48phút", "Spiderman", "13+", "Hành động", "Tiếng Anh - Phụ đề tiếng Việt; Lồng Tiếng"));
        phims.add(new PHIM(R.drawable.nen5, "Người nhện: Du hành vũ trụ nhện", " 01thg 6 2023 2giờ 20phút", "Doremon", "13+", "Hành động", "Tiếng Anh - Phụ đề tiếng Việt; Lồng Tiếng"));
        return phims;

    }

    private void intiToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbarcp);

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
//                Toast.makeText(getApplication(),"Menu", Toast.LENGTH_SHORT).show();
                drawerLayout.openDrawer(GravityCompat.END);
                break;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}