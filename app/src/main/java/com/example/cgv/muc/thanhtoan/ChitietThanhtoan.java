package com.example.cgv.muc.thanhtoan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.cgv.MainActivity;
import com.example.cgv.R;
import com.example.cgv.muc.datve.ChonGhe.Customtoast;
import com.example.cgv.muc.datve.ChonGhe.GheAdapter;
import com.example.cgv.muc.login.vecuatoi.VE;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ChitietThanhtoan extends AppCompatActivity {

    TextView ten, ngay, sbd, skt, ghe, tongcong, btn_home;
    public static String time_datve, ten_ve, ngay_ve, sbd_ve, skt_ve, ghe_ve, tong_ve;

    public static ArrayList<VE> ves = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet_thanhtoan);

        anhxa();
        intiToolbar();

        ten_ve = getIntent().getStringExtra("TEN");
        ngay_ve = getIntent().getStringExtra("NGAY");
        sbd_ve = getIntent().getStringExtra("FROM");
        skt_ve = getIntent().getStringExtra("TO");
        ghe_ve = getIntent().getStringExtra("GHE");
        tong_ve = getIntent().getStringExtra("TIEN");

        ten.setText(ten_ve);
        ngay.setText(ngay_ve);
        sbd.setText(sbd_ve);
        skt.setText(skt_ve);
        ghe.setText(ghe_ve);
        tongcong.setText(tong_ve);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        ChitietThanhtoan.time_datve = dateFormat.format(date);

        ves.add(new VE(ChitietThanhtoan.ten_ve, ChitietThanhtoan.ngay_ve, ChitietThanhtoan.sbd_ve, ChitietThanhtoan.skt_ve, ChitietThanhtoan.ghe_ve, ChitietThanhtoan.tong_ve, ChitietThanhtoan.time_datve));

        int sl = 1;
        if (sl>=2){
            for (int i = 0; i <= ves.size(); i++){
                if (i%2 == 0){
                    ves.remove(i);
                }
            }
        }
        sl++;


        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChitietThanhtoan.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ThanhToan.danhsachdachon = GheAdapter.danhsachchon;
        GheAdapter.danhsachchon.clear();
        ThanhToan.tienve = GheAdapter.thanhtien;
        GheAdapter.thanhtien = 0;

    }

    private void anhxa(){
        ten = findViewById(R.id.tt_tenphim);
        ngay = findViewById(R.id.tt_ngay);
        sbd = findViewById(R.id.tt_bd);
        skt = findViewById(R.id.tt_kt);
        ghe = findViewById(R.id.tt_ghe);
        tongcong = findViewById(R.id.tt_tien);
        btn_home = findViewById(R.id.btn_home);
    }

    private void intiToolbar(){
        Toolbar toolbartt = findViewById(R.id.toolbarchitietthanhtoan);

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