package com.example.cgv.muc.login.thanhvien;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.cgv.MainActivity;
import com.example.cgv.R;
import com.example.cgv.muc.login.Login;
import com.example.cgv.muc.login.vecuatoi.VeCuaToi;

import java.util.ArrayList;

public class ThanhVien extends AppCompatActivity {

    RecyclerView rv_cttv;

    ArrayList<CTTV> cttvs = new ArrayList<>();
    CttvAdapter cttvAdapter;

    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_vien);

        rv_cttv = findViewById(R.id.rvThanhvien);
        name = findViewById(R.id.name_user);

        intiToolbar();
        setCTTV();

        name.setText(MainActivity.mUser.getUsername());
    }

    public void setCTTV(){
        cttvs.add(new CTTV(R.drawable.icons_account, "Thông tin tài khoản"));
        cttvs.add(new CTTV(R.drawable.icons_padlock, "Thay đổi mật khẩu"));
        cttvs.add(new CTTV(R.drawable.icons_payment_security, "Cài đặt mật mã thanh toán"));
        cttvs.add(new CTTV(R.drawable.icons_member, "Thẻ thành viên"));
        cttvs.add(new CTTV(R.drawable.icons_coin, "Điểm CGV"));
        cttvs.add(new CTTV(R.drawable.icons_card, "Thẻ quà tặng | Voucher | Coupon"));
        cttvs.add(new CTTV(R.drawable.icons_transaction, "Lịch sử giao dịch"));

        cttvAdapter = new CttvAdapter(this, cttvs);
        rv_cttv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rv_cttv.setAdapter(cttvAdapter);
    }


    private void intiToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbarthanhvien);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_red, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.ticketID:
                Intent intentve = new Intent(ThanhVien.this, VeCuaToi.class);
                startActivity(intentve);
                break;
            case R.id.menuID:
//                Toast.makeText(getApplication(), "menu", Toast.LENGTH_SHORT).show();
//                drawerLayout.openDrawer(GravityCompat.END);
                break;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}