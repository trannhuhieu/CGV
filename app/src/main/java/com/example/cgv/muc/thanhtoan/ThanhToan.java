package com.example.cgv.muc.thanhtoan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cgv.MainActivity;
import com.example.cgv.R;
import com.example.cgv.muc.datve.ChonGhe.GHE;
import com.example.cgv.muc.datve.ChonGhe.GheAdapter;
import com.example.cgv.muc.login.vecuatoi.VeCuaToi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ThanhToan extends AppCompatActivity {

    ImageView hinh;
    TextView ten, ngay, sbd, skt, ghe, thanhtoan, tongve, tong, vat, conlai, dieukhoan, btn_thanhtoan;
//    Button btn_thanhtoan;
    RecyclerView rv_giamgia;

    ArrayList<GIAMGIA> giamgias = new ArrayList<>();
    GiamGiaAdapter giamGiaAdapter;

    private DialogInterface.OnClickListener dialogClickListener;

    public static ArrayList<Integer> danhsachdachon = new ArrayList<Integer>();
    public static int tienve = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan);

        hinh = findViewById(R.id.imgp);
        ten = findViewById(R.id.tenp);
        ngay = findViewById(R.id.ngay);
        sbd = findViewById(R.id.bd);
        skt = findViewById(R.id.kt);
        ghe = findViewById(R.id.ghe);
        thanhtoan = findViewById(R.id.tongtien);
        tongve = findViewById(R.id.tongve);
        tong = findViewById(R.id.tong);
        vat = findViewById(R.id.tongvat);
        conlai = findViewById(R.id.conlai);
        dieukhoan = findViewById(R.id.tv_dk);
        rv_giamgia = findViewById(R.id.rv_giamgia);
        btn_thanhtoan = findViewById(R.id.btn_thanhtoan);

        intiToolbar();

        hinh.setImageResource(getIntent().getIntExtra("HINH", 0));
        ten.setText(getIntent().getStringExtra("TEN"));
        ngay.setText(getIntent().getStringExtra("NGAY"));
        sbd.setText(getIntent().getStringExtra("FROM"));
        skt.setText(getIntent().getStringExtra("TO"));

        String text = "";
        ghe.setText(text);
        if (GheAdapter.danhsachchon != null) {

            for (int item = 0; item<GheAdapter.danhsachchon.size(); item++) {
                if (GheAdapter.danhsachchon.get(item) > 14 && GheAdapter.danhsachchon.get(item) < 42){
                    text += "V"+GheAdapter.danhsachchon.get(item) + ", ";
                }else {
                    text += "A"+GheAdapter.danhsachchon.get(item) + ", ";
                }
            }
            ghe.setText(text);
        }

        String textTT = "";
        textTT += GheAdapter.thanhtien;
        thanhtoan.setText(textTT);
        tong.setText(textTT);
        vat.setText(textTT);
        conlai.setText(textTT);

        String textTV = "";
        if (GheAdapter.danhsachchon != null){
            textTV += GheAdapter.danhsachchon.size();
            tongve.setText(textTV);
        }else {
            textTV = "";
        }


        String htmlcontent = "<a href=\"...\">Điều Khoản Sử Dụng</a>";
        dieukhoan.setText(android.text.Html.fromHtml(htmlcontent));
        dieukhoan.setLinkTextColor(getResources().getColor(R.color.red));

        setGiamGia();

        btn_thanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSimpleDialog();
            }
        });
    }

    private void showSimpleDialog(){
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this);
        builder.setMessage("Bạn có chắc muốn mua vé không?")
                .setCancelable(false)
                .setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(ThanhToan.this, ChitietThanhtoan.class);
                        intent.putExtra("TEN", getIntent().getStringExtra("TEN"));
                        intent.putExtra("NGAY", getIntent().getStringExtra("NGAY"));
                        intent.putExtra("FROM", getIntent().getStringExtra("FROM"));
                        intent.putExtra("TO", getIntent().getStringExtra("TO"));
                        intent.putExtra("GHE", ghe.getText());
                        intent.putExtra("TIEN", thanhtoan.getText());
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void setGiamGia(){
        giamgias.add(new GIAMGIA("CGV Voucher"));
        giamgias.add(new GIAMGIA("CGV Coupon"));
        giamgias.add(new GIAMGIA("Điểm CGV"));
        giamgias.add(new GIAMGIA("Thẻ Quà Tặng"));
        giamgias.add(new GIAMGIA("Thẻ Ưu Tiên"));
        giamgias.add(new GIAMGIA("Đối Tác"));
        giamgias.add(new GIAMGIA("Mã Khuyến Mãi"));

        giamGiaAdapter = new GiamGiaAdapter(this, giamgias);
        rv_giamgia.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rv_giamgia.setAdapter(giamGiaAdapter);
        DividerItemDecoration dividerHorizontal = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rv_giamgia.addItemDecoration(dividerHorizontal);
    }

    private void intiToolbar(){
        Toolbar toolbartt = findViewById(R.id.toolbarthanhtoan);

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
                GheAdapter.danhsachchon = null;
                GheAdapter.thanhtien = 0;
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