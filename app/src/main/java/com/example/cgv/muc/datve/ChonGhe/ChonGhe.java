package com.example.cgv.muc.datve.ChonGhe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cgv.MainActivity;
import com.example.cgv.R;
import com.example.cgv.muc.login.Login;
import com.example.cgv.muc.thanhtoan.ThanhToan;
import com.example.cgv.muc.tintuc.tin.All_tin;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class ChonGhe extends AppCompatActivity {

    DrawerLayout drawerLayout;

    ImageView btnback, btnmenu;
    TextView date, suatbd, suatkt, tenphim, btndave;

    ArrayList<GHE> ghes = new ArrayList<>();
    GheAdapter gheAdapter;

    RecyclerView rv_ghe;
    public static TextView gia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_ghe);

        drawerLayout = findViewById(R.id.drawer_layout);
        btnback = findViewById(R.id.back);
        btnmenu = findViewById(R.id.menu);
        date = findViewById(R.id.ngaydat);
        suatbd = findViewById(R.id.giodat);
        suatkt = findViewById(R.id.giokt);
        tenphim = findViewById(R.id.phimdat);
        btndave = findViewById(R.id.datve);
        rv_ghe = findViewById(R.id.rv_chonghe);
        gia = findViewById(R.id.giaghe);

        date.setText(getIntent().getStringExtra("NGAY"));
        suatbd.setText(getIntent().getStringExtra("FROM"));
        suatkt.setText(getIntent().getStringExtra("TO"));
        tenphim.setText(getIntent().getStringExtra("TEN"));

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GheAdapter.danhsachchon = null;
                GheAdapter.thanhtien = 0;
                onBackPressed();
            }
        });

        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.END);
            }
        });

        setNavigationView();
        setGhes();

        btndave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (GheAdapter.thanhtien == 0){
                    Customtoast.makeText(getApplicationContext(), "Xin chọn ít nhất vé", Customtoast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(ChonGhe.this, ThanhToan.class);
                    intent.putExtra("TEN", getIntent().getStringExtra("TEN"));
                    intent.putExtra("HINH", getIntent().getIntExtra("HINHP", 0));
                    intent.putExtra("NGAY", getIntent().getStringExtra("NGAY"));
                    intent.putExtra("FROM", getIntent().getStringExtra("FROM"));
                    intent.putExtra("TO", getIntent().getStringExtra("TO"));
                    startActivity(intent);
                    finish();
                }
            }
        });
    }


    public void setGhes(){



        ghes = getGheData();
        gheAdapter = new GheAdapter(this, ghes);
        rv_ghe.setLayoutManager(new GridLayoutManager(this, 7, RecyclerView.HORIZONTAL, false));
        rv_ghe.setAdapter(gheAdapter);
        rv_ghe.addItemDecoration(new SpacesItemDecoration(30));

    }

    public ArrayList<GHE>  getGheData(){
        ghes = new ArrayList<>();

        ghes.add(new GHE("S001", "A", "1"));
        ghes.add(new GHE("S002", "A", "2"));
        ghes.add(new GHE("S003", "A", "3"));
        ghes.add(new GHE("S004", "A", "4"));
        ghes.add(new GHE("S005", "A", "5"));
        ghes.add(new GHE("S006", "A", "6"));
        ghes.add(new GHE("S007", "A", "7"));
        ghes.add(new GHE("S008", "A", "8"));
        ghes.add(new GHE("S009", "A", "9"));
        ghes.add(new GHE("S0010", "A", "10"));
        ghes.add(new GHE("S0011", "A", "11"));
        ghes.add(new GHE("S0012", "A", "12"));
        ghes.add(new GHE("S0013", "A", "13"));
        ghes.add(new GHE("S0014", "A", "14"));
        ghes.add(new GHE("S0015", "V", "15"));
        ghes.add(new GHE("S0016", "V", "16"));

        ghes.add(new GHE("S001", "V", "17"));
        ghes.add(new GHE("S002", "V", "18"));
        ghes.add(new GHE("S003", "V", "19"));
        ghes.add(new GHE("S004", "V", "20"));
        ghes.add(new GHE("S005", "V", "21"));
        ghes.add(new GHE("S006", "V", "22"));
        ghes.add(new GHE("S007", "V", "23"));
        ghes.add(new GHE("S008", "V", "24"));
        ghes.add(new GHE("S009", "V", "25"));
        ghes.add(new GHE("S0010", "V", "26"));
        ghes.add(new GHE("S0011", "V", "27"));
        ghes.add(new GHE("S0012", "V", "28"));
        ghes.add(new GHE("S0013", "V", "29"));
        ghes.add(new GHE("S0014", "V", "30"));
        ghes.add(new GHE("S0015", "V", "31"));
        ghes.add(new GHE("S0016", "V", "32"));

        ghes.add(new GHE("S001", "V", "33"));
        ghes.add(new GHE("S002", "V", "34"));
        ghes.add(new GHE("S003", "V", "35"));
        ghes.add(new GHE("S004", "V", "36"));
        ghes.add(new GHE("S005", "V", "37"));
        ghes.add(new GHE("S006", "V", "38"));
        ghes.add(new GHE("S007", "V", "39"));
        ghes.add(new GHE("S008", "V", "40"));
        ghes.add(new GHE("S009", "V", "41"));
        ghes.add(new GHE("S0010", "V", "42"));
        ghes.add(new GHE("S0011", "A", "43"));
        ghes.add(new GHE("S0012", "A", "44"));
        ghes.add(new GHE("S0013", "A", "45"));
        ghes.add(new GHE("S0014", "A", "46"));
        ghes.add(new GHE("S0015", "A", "47"));
        ghes.add(new GHE("S0016", "A", "48"));

        ghes.add(new GHE("S001", "A", "49"));
        ghes.add(new GHE("S002", "A", "50"));
        ghes.add(new GHE("S003", "A", "51"));
        ghes.add(new GHE("S004", "A", "52"));
        ghes.add(new GHE("S005", "A", "53"));
        ghes.add(new GHE("S006", "A", "54"));
        ghes.add(new GHE("S007", "A", "55"));
        ghes.add(new GHE("S008", "A", "56"));

        return ghes;
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
                Intent trangchu = new Intent(ChonGhe.this, MainActivity.class);
                startActivity(trangchu);
                finish();
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Thành viên", Toast.LENGTH_SHORT).show();
                Intent thanhvien = new Intent(ChonGhe.this, Login.class);
                startActivity(thanhvien);
            }
        });
        rcgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Rạp CGV", Toast.LENGTH_SHORT).show();
//                Intent thanhvien = new Intent(MainActivity.this, Login.class);
//                startActivity(thanhvien);
            }
        });
        rdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Rạp đặc biệt", Toast.LENGTH_SHORT).show();
//                Intent thanhvien = new Intent(MainActivity.this, Login.class);
//                startActivity(thanhvien);
            }
        });
        tm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Tin mới & Ưu đãi", Toast.LENGTH_SHORT).show();
                Intent tin = new Intent(ChonGhe.this, All_tin.class);
                startActivity(tin);
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

}