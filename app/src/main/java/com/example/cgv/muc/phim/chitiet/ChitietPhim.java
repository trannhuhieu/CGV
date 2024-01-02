package com.example.cgv.muc.phim.chitiet;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cgv.MainActivity;
import com.example.cgv.R;
import com.example.cgv.muc.datve.phim.Datve_phim;
import com.example.cgv.muc.tintuc.Adapter.TINTUC;
import com.example.cgv.muc.tintuc.Adapter.TinAdapter;
import com.example.cgv.muc.tintuc.tin.All_tin;
import com.example.cgv.muc.trailer.trailer_phim;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class ChitietPhim extends AppCompatActivity {
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ImageView hinh, play, trailer;
    TextView ten, thoigian, noidung, kiemduyet, theloai, ngongu, btnall, btndatve;
//    ViewPager viewPagertin;
    RecyclerView rvtin;
    private ArrayList<TINTUC> tintucs;
    private TinAdapter tinAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet_phim);

        anhxa();
        intiToolbar();
        setNavigationView();

        int idPhim = getIntent().getIntExtra("ID_PHIM", 0);
        String tenPhim = getIntent().getStringExtra("TEN_PHIM");
        String thoiGian = getIntent().getStringExtra("THOI_GIAN");
        String anoidung = getIntent().getStringExtra("NOIDUNG");
        String akiemduyet = getIntent().getStringExtra("KIEMDUYET");
        String atheloai = getIntent().getStringExtra("THELOAI");
        String angonngu = getIntent().getStringExtra("NGONNGU");

        trailer.setBackgroundResource(idPhim);
        hinh.setImageResource(idPhim);
        ten.setText(tenPhim);
        thoigian.setText(thoiGian);
        noidung.setText(anoidung);
        kiemduyet.setText(akiemduyet);
        theloai.setText(atheloai);
        ngongu.setText(angonngu);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChitietPhim.this, trailer_phim.class);
                intent.putExtra("ten", tenPhim);
                startActivity(intent);
            }
        });

//        viewPagertin.setOffscreenPageLimit(3);
//        viewPagertin.setClipToPadding(false);
//        viewPagertin.setClipChildren(false);
        tintucs = getListTin();
        tinAdapter = new TinAdapter(this, tintucs);
        rvtin.setAdapter(tinAdapter);
        rvtin.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        btnall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChitietPhim.this, All_tin.class);
                startActivity(intent);
            }
        });

        btndatve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChitietPhim.this, Datve_phim.class);
                intent.putExtra("HINH", idPhim);
                intent.putExtra("TEN", tenPhim);
                startActivity(intent);
            }
        });

    }

    public void setNavigationView(){
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
            user.setText("AAAA");

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

        tintucs.add(new TINTUC(R.drawable.tin2, "Chính thức: Thời gian và địa điểm nhận quà VVIP2023\"", "v.v.v"));
        tintucs.add(new TINTUC(R.drawable.tin3, "Tháng 6 vui vẻ, chỉ 14k 1 vé phim hay", "v.v.v"));
        tintucs.add(new TINTUC(R.drawable.tin4, "Chương trình ưu đãi dành cho chủ thẻ OCB tại CGV", "v.v.v"));
        tintucs.add(new TINTUC(R.drawable.tin5, "[CERAVE X CGV] CERAVE có CERAMIDES - Khóa ẩm làn da", "v.v.v"));
        tintucs.add(new TINTUC(R.drawable.tin6, "Chào hè với giá vé CGV cực hay", "v.v.v"));
        tintucs.add(new TINTUC(R.drawable.tin7, "Miễn phí UPSIZE bắp nước, thanh toán ZALOPAY", "v.v.v"));
        tintucs.add(new TINTUC(R.drawable.tin8, "Chương trình ưu dãi chỉ 135k cho 2 vé phim", "v.v.v"));
        tintucs.add(new TINTUC(R.drawable.tin1, "Khảo sát hình tượng diễn viên Kiều Minh Tuấn trong phim mới", "v.v.v"));

        return tintucs;
    }


    private void anhxa() {
        drawerLayout = findViewById(R.id.drawer_layout);
        hinh = findViewById(R.id.small_image);
        ten = findViewById(R.id.content);
        thoigian = findViewById(R.id.con);
        trailer = findViewById(R.id.image_trailer);
        play = findViewById(R.id.play);
        noidung = findViewById(R.id.noidung);
        kiemduyet = findViewById(R.id.kiemduyet);
        theloai = findViewById(R.id.theloai);
        ngongu = findViewById(R.id.ngonngu);
//        viewPagertin = findViewById(R.id.tintuc);
        btnall = findViewById(R.id.alltin);
        rvtin = findViewById(R.id.tintuc);
        btndatve = findViewById(R.id.datvechitiet);
        navigationView = findViewById(R.id.nav_view);
    }

    private void intiToolbar(){
        Toolbar toolbarP = findViewById(R.id.toolbarPhim);

        setSupportActionBar(toolbarP);
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
                drawerLayout.openDrawer(GravityCompat.END);
                break;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}