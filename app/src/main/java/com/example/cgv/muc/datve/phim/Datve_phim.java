package com.example.cgv.muc.datve.phim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cgv.MainActivity;
import com.example.cgv.R;
import com.example.cgv.muc.datve.ChonGhe.ChonGhe;
import com.example.cgv.muc.datve.theophim.Datve_theophim;
import com.example.cgv.muc.datve.theorap.Datve_theorap;
import com.example.cgv.muc.goi.GOI;
import com.example.cgv.muc.login.Login;
import com.example.cgv.muc.login.vecuatoi.VeCuaToi;
import com.example.cgv.muc.phim.adapter.PHIM;
import com.example.cgv.muc.phim.adapter.PhimAdapter;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Calendar;

public class Datve_phim extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    LinearLayout dinhdang, setlich;
    TextView option, date, s1, s2, s3, s4, s5, kts1, kts2, kts3, kts4, kts5;
    ViewPager2 vplich;
    String tenPhim;

    ArrayList<LICH> liches = new ArrayList<>();
    LichAdapter lichAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datve_phim);

        anhxa();
        intiToolbar();
        setNavigationView();

        tenPhim = getIntent().getStringExtra("TEN");
        toolbar.setTitle(tenPhim);

        dinhdang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFeedBackDiaLog(Gravity.CENTER);
            }
        });

        setLich();

        setlich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDiaLogLich(Gravity.CENTER);
            }
        });

        setSuatphims();

    }

    public void anhxa(){
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbardphim);
        dinhdang = findViewById(R.id.dinhdang);
        option = findViewById(R.id.ddoption);
        vplich = findViewById(R.id.vplich);
        date = findViewById(R.id.ngaythang);
        setlich = findViewById(R.id.setlich);
//        rv_suat = findViewById(R.id.rv_suat);
        s1 = findViewById(R.id.s1);
        s2 = findViewById(R.id.s2);
        s3 = findViewById(R.id.s3);
        s4 = findViewById(R.id.s4);
        s5 = findViewById(R.id.s5);
        kts1 = findViewById(R.id.s1kt);
        kts2 = findViewById(R.id.s2kt);
        kts3 = findViewById(R.id.s3kt);
        kts4 = findViewById(R.id.s4kt);
        kts5 = findViewById(R.id.s5kt);
    }

    public void setSuatphims(){
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.isHasUser){
                    Intent intent = new Intent(Datve_phim.this, ChonGhe.class);
                    intent.putExtra("NGAY", date.getText());
                    intent.putExtra("FROM", s1.getText());
                    intent.putExtra("TO", kts1.getText());
                    intent.putExtra("TEN", tenPhim);
                    intent.putExtra("HINHP", getIntent().getIntExtra("HINH", 0));
                    startActivity(intent);
                }else {
                    Intent intentdn = new Intent(Datve_phim.this, Login.class);
                    startActivity(intentdn);
                }
            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.isHasUser){
                    Intent intent = new Intent(Datve_phim.this, ChonGhe.class);
                    intent.putExtra("NGAY", date.getText());
                    intent.putExtra("FROM", s2.getText());
                    intent.putExtra("TO", kts2.getText());
                    intent.putExtra("TEN", tenPhim);
                    intent.putExtra("HINHP", getIntent().getIntExtra("HINH", 0));
                    startActivity(intent);
                }else {
                    Intent intentdn = new Intent(Datve_phim.this, Login.class);
                    startActivity(intentdn);
                }
            }
        });
        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.isHasUser){
                    Intent intent = new Intent(Datve_phim.this, ChonGhe.class);
                    intent.putExtra("NGAY", date.getText());
                    intent.putExtra("FROM", s3.getText());
                    intent.putExtra("TO", kts3.getText());
                    intent.putExtra("TEN", tenPhim);
                    intent.putExtra("HINHP", getIntent().getIntExtra("HINH", 0));
                    startActivity(intent);
                }else {
                    Intent intentdn = new Intent(Datve_phim.this, Login.class);
                    startActivity(intentdn);
                }

            }
        });
        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.isHasUser){
                    Intent intent = new Intent(Datve_phim.this, ChonGhe.class);
                    intent.putExtra("NGAY", date.getText());
                    intent.putExtra("FROM", s4.getText());
                    intent.putExtra("TO", kts4.getText());
                    intent.putExtra("TEN", tenPhim);
                    intent.putExtra("HINHP", getIntent().getIntExtra("HINH", 0));
                    startActivity(intent);
                }else {
                    Intent intentdn = new Intent(Datve_phim.this, Login.class);
                    startActivity(intentdn);
                }

            }
        });
        s5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.isHasUser){
                    Intent intent = new Intent(Datve_phim.this, ChonGhe.class);
                    intent.putExtra("NGAY", date.getText());
                    intent.putExtra("FROM", s5.getText());
                    intent.putExtra("TO", kts5.getText());
                    intent.putExtra("TEN", tenPhim);
                    intent.putExtra("HINHP", getIntent().getIntExtra("HINH", 0));
                    startActivity(intent);
                }else {
                    Intent intentdn = new Intent(Datve_phim.this, Login.class);
                    startActivity(intentdn);
                }

            }
        });
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

    private void intiToolbar(){

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);
        }
    }

    private void openFeedBackDiaLog(int gravity){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_ddphim);

        Window window = dialog.getWindow();
        if (window == null)
            return;

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams winLayoutParams = window.getAttributes();
        winLayoutParams.gravity = gravity;
        window.setAttributes(winLayoutParams);

        dialog.setCancelable(true);
        dialog.show();

        TextView all, p2d;
        all = dialog.findViewById(R.id.all);
        p2d = dialog.findViewById(R.id.p2d);

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option.setText("TẤT CẢ");
                dialog.dismiss();
            }
        });

        p2d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option.setText("2D");
                dialog.dismiss();
            }
        });
    }

    public void setLich(){
        liches = getDataLich();
        lichAdapter = new LichAdapter(this, liches);
        vplich.setAdapter(lichAdapter);

        vplich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDiaLogLich(Gravity.CENTER);
            }
        });

    }

    public ArrayList<LICH> getDataLich(){

        liches.add(new LICH("25", "26", "27", "28", "29", "30", "1"));
        liches.add(new LICH("2", "3", "4", "5", "6", "7", "8"));
        liches.add(new LICH("9", "10", "11", "12", "13", "14", "15"));
        liches.add(new LICH("16", "17", "18", "19", "20", "21", "22"));
        liches.add(new LICH("23", "24", "25", "26", "27", "28", "29"));

        return liches;
    }

    private void openDiaLogLich(int gravity){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialoglich);

        Window window = dialog.getWindow();
        if (window == null)
            return;

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams winLayoutParams = window.getAttributes();
        winLayoutParams.gravity = gravity;
        window.setAttributes(winLayoutParams);

        dialog.setCancelable(false);
        dialog.show();

        TextView n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15
                , n16, n17, n18, n19, n20, n21, n22, n23, n24, n25, n26, n27, n28;
        Button btnhuy;
        n1 = dialog.findViewById(R.id.n1);
        n2 = dialog.findViewById(R.id.n2);
        n3 = dialog.findViewById(R.id.n3);
        n4 = dialog.findViewById(R.id.n4);
        n5 = dialog.findViewById(R.id.n5);
        n6 = dialog.findViewById(R.id.n6);
        n7 = dialog.findViewById(R.id.n7);
        n8 = dialog.findViewById(R.id.n8);
        n9 = dialog.findViewById(R.id.n9);
        n10 = dialog.findViewById(R.id.n10);
        n11 = dialog.findViewById(R.id.n11);
        n12 = dialog.findViewById(R.id.n12);
        n13 = dialog.findViewById(R.id.n13);
        n14 = dialog.findViewById(R.id.n14);
        n15 = dialog.findViewById(R.id.n15);
        n16 = dialog.findViewById(R.id.n16);
        n17 = dialog.findViewById(R.id.n17);
        n18 = dialog.findViewById(R.id.n18);
        n19 = dialog.findViewById(R.id.n19);
        n20 = dialog.findViewById(R.id.n20);
        n21 = dialog.findViewById(R.id.n21);
        n22 = dialog.findViewById(R.id.n22);
        n23 = dialog.findViewById(R.id.n23);
        n24 = dialog.findViewById(R.id.n24);
        n25 = dialog.findViewById(R.id.n25);
        n26 = dialog.findViewById(R.id.n26);
        n27 = dialog.findViewById(R.id.n27);
        n28 = dialog.findViewById(R.id.n28);

        btnhuy = dialog.findViewById(R.id.canot);

        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("Chủ Nhật 25 tháng 6, 2023");
                dialog.dismiss();
            }
        });

        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("Thứ Hai 26 tháng 6, 2023");
                dialog.dismiss();
            }
        });
        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("Thứ Ba 27 tháng 6, 2023");
                dialog.dismiss();
            }
        });
        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("Thứ Tư 28 tháng 6, 2023");
                dialog.dismiss();
            }
        });
        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("Thứ Năm 29 tháng 6, 2023");
                dialog.dismiss();
            }
        });
        n6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("Thứ Sáu 30 tháng 6, 2023");
                dialog.dismiss();
            }
        });
        n7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("Thứ Bảy 1 tháng 7, 2023");
                dialog.dismiss();
            }
        });

        n8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("Thứ Hai 2 tháng 7, 2023");
                dialog.dismiss();
            }
        });

        n9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("Thứ Ba 3 tháng 7, 2023");
                dialog.dismiss();
            }
        });
        n10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("Thứ Tư 4 tháng 7, 2023");
                dialog.dismiss();
            }
        });
        n11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("Thứ Năm 5 tháng 7, 2023");
                dialog.dismiss();
            }
        });
        n12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("Thứ Sáu 6 tháng 7, 2023");
                dialog.dismiss();
            }
        });
        n13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("Thứ Bảy 7 tháng 7, 2023");
                dialog.dismiss();
            }
        });
        n14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("Chủ Nhật 9 tháng 7, 2023");
                dialog.dismiss();
            }
        });
        n15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("Thứ Hai 10 tháng 7, 2023");
                dialog.dismiss();
            }
        });

        n16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("Thứ Ba 11 tháng 7, 2023");
                dialog.dismiss();
            }
        });
        n17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("Thứ Tư 12 tháng 7, 2023");
                dialog.dismiss();
            }
        });
        n18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("Thứ Năm 13 tháng 7, 2023");
                dialog.dismiss();
            }
        });
        n19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("Thứ Sáu 14 tháng 7, 2023");
                dialog.dismiss();
            }
        });
        n20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("Thứ Bảy 15 tháng 7, 2023");
                dialog.dismiss();
            }
        });
        n21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("Chủ Nhật 16 tháng 7, 2023");
                dialog.dismiss();
            }
        });
        n22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("Thứ Hai 17 tháng 7, 2023");
                dialog.dismiss();
            }
        });
        n23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("Thứ Ba 18 tháng 8, 2023");
                dialog.dismiss();
            }
        });
        n24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("Thứ Tư 19 tháng 7, 2023");
                dialog.dismiss();
            }
        });
        n25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("Thứ Năm 20 tháng 7, 2023");
                dialog.dismiss();
            }
        });
        n26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("Thứ Sáu 21 tháng 7, 2023");
                dialog.dismiss();
            }
        });
        n27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("Thứ Bảy 22 tháng 7, 2023");
                dialog.dismiss();
            }
        });
        n28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("Chủ Nhật 23 tháng 7, 2023");
                dialog.dismiss();
            }
        });

        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
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