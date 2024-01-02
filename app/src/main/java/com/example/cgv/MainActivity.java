package com.example.cgv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cgv.muc.goi.GOI;
import com.example.cgv.muc.goi.GoiAdapter;
import com.example.cgv.muc.login.Login;
import com.example.cgv.muc.login.User;
import com.example.cgv.muc.login.thanhvien.ThanhVien;
import com.example.cgv.muc.login.vecuatoi.VeCuaToi;
import com.example.cgv.muc.rapCGV.MovieTheater;
import com.example.cgv.muc.tintuc.Adapter.KENHCINE;
import com.example.cgv.muc.tintuc.Adapter.KenhCineAdapter;
import com.example.cgv.muc.tintuc.Adapter.TINTUC;
import com.example.cgv.muc.tintuc.Adapter.TinnongAdapter;
import com.example.cgv.muc.tintuc.tin.All_tin;
import com.example.cgv.muc.banner.SLIDE;
import com.example.cgv.muc.banner.SlideAdapter;
import com.example.cgv.muc.uudai.Uudai;
import com.example.cgv.muc.videos.All_Videos;
import com.example.cgv.muc.videos.VIDEO;
import com.example.cgv.muc.videos.VideosAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private TabLayout tabLayout;
    private ViewPager2 viewPager2, viewPager2banner, viewPager2Uudai;
    private ViewPagerAdapter viewPagerAdapter;

    private List<SLIDE> list;

    private TextView btnalltin, btnallvideos, textView_tim, btndangxuat;

    private RecyclerView rv_tinnong, rv_goi, rv_videos, rv_kenhcine;
    private ArrayList<TINTUC> tinnong = new ArrayList<>();
    TinnongAdapter tinnongAdapter;

    private ArrayList<GOI> goidata = new ArrayList<>();
    GoiAdapter goiAdapter;

    public static boolean isHasUser = true;
    public static User mUser = new User("123", "abc", "abc123456");

    Handler handler = new Handler(Looper.getMainLooper());
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            int curren = viewPager2banner.getCurrentItem();
            int currenUd = viewPager2Uudai.getCurrentItem();
            if (curren == list.size() - 1){
                viewPager2banner.setCurrentItem(0);
                viewPager2Uudai.setCurrentItem(0);
            }else {
                viewPager2banner.setCurrentItem(curren + 1);
                viewPager2Uudai.setCurrentItem(currenUd + 1);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhxa();
        intiToolbar();

        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(viewPagerAdapter);
        viewPager2.setUserInputEnabled(false);


        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            switch (position){
                case 0:
                    tab.setText("Đang chiếu");
                    break;
                case 1:
                    tab.setText("Đặc biệt");
                    break;
                case 2:
                    tab.setText("Sắp chiếu");
                    break;
            }
        }).attach();

        setNavigationView();
        setBanner();
        settextcolortablayout();
        setGoi();
        setTinnong();
        setVideos();
        setKenhCine();
        setUudai();

        textView_tim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MovieTheater.class);
                startActivity(intent);
            }
        });

        btnalltin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, All_tin.class);
                startActivity(intent);
            }
        });

        btnallvideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, All_Videos.class);
                startActivity(intent);
            }
        });
    }

    private void anhxa() {
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        tabLayout = findViewById(R.id.tab);
        viewPager2 = findViewById(R.id.viewpager2);
        viewPager2banner = findViewById(R.id.banner);
        btnalltin = findViewById(R.id.main_alltin);
        viewPager2Uudai = findViewById(R.id.uudaidoitac);
        rv_tinnong = findViewById(R.id.rv_tinnong);
        rv_goi = findViewById(R.id.rv_goi);
        rv_videos = findViewById(R.id.rv_videos);
        rv_kenhcine = findViewById(R.id.rv_kenhCine);
        btnallvideos = findViewById(R.id.btn_allvideos);
        textView_tim = findViewById(R.id.edit_tim);
    }

    private void intiToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.popcorn);

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
            user.setText(MainActivity.mUser.getUsername());
            user.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, ThanhVien.class);
                    startActivity(intent);
                }
            });

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

            user.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, Login.class);
                    startActivity(intent);
                }
            });
        }


        tc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Trang chủ", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawers();
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Thành viên", Toast.LENGTH_SHORT).show();
                Intent thanhvien = new Intent(MainActivity.this, Login.class);
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
                Intent tin = new Intent(MainActivity.this, All_tin.class);
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

    public void setBanner(){
        viewPager2banner.setOffscreenPageLimit(3);
        viewPager2banner.setClipToPadding(false);
        viewPager2banner.setClipChildren(false);

        list = getListSlide();
        SlideAdapter slideAdapter = new SlideAdapter(this, list);
        viewPager2banner.setAdapter(slideAdapter);

        viewPager2banner.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 3000);
            }
        });
    }

    public void setGoi(){

        goidata = getGoidata();
        goiAdapter = new GoiAdapter(goidata);
        rv_goi.setAdapter(goiAdapter);
        rv_goi.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }

    public ArrayList<GOI> getGoidata(){

        goidata.add(new GOI(R.drawable.goi2, "Thuê rạp & vé nhóm"));
        goidata.add(new GOI(R.drawable.goi4, "GCV Store"));
        goidata.add(new GOI(R.drawable.goi1, "Imax"));
        goidata.add(new GOI(R.drawable.goi3, "4dx"));
        goidata.add(new GOI(R.drawable.goi5, "sweet box"));
        goidata.add(new GOI(R.drawable.goi6, "giải trí cùng cgv"));

        return goidata;
    }

    public void setTinnong(){
        tinnong.add(new TINTUC(R.drawable.tin1, "Khảo sát hình tượng diễn viên kiều minh tuấn trong phim mới", "11/06/2023"));
        tinnong.add(new TINTUC(R.drawable.tin2, "Chính thức: Thời gian và địa điểm nhận quà VVIP2023", "11/06/2023"));
        tinnong.add(new TINTUC(R.drawable.tin3, "Tháng 6 vui vẻ, chỉ 14k 1 vé phim hay", "11/06/2023"));
        tinnong.add(new TINTUC(R.drawable.tin4, "Chương trình ưu đãi dành cho chủ thẻ OCB tại CGV", "11/06/2023"));
        tinnong.add(new TINTUC(R.drawable.tin5, "[CERAVE X CGV] CERAVE có CERAMIDES - Khóa ẩm làn da", "11/06/2023"));
        tinnong.add(new TINTUC(R.drawable.tin6, "Chào hè với giá vé CGV cực hay", "11/06/2023"));

        tinnongAdapter = new TinnongAdapter(this, tinnong);
        rv_tinnong.setAdapter(tinnongAdapter);
        rv_tinnong.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    public void setVideos(){
        ArrayList<VIDEO> videos = new ArrayList<>();
        videos.add(new VIDEO(R.drawable.video1, "MAVKA: THẦN THOẠI RỪNG XANH | OFFICIAL TRAILER 2 | KC: 16.06.2023"));
        videos.add(new VIDEO(R.drawable.video2, "FAST & FURIOUS X | Trailer K | Dự Kiến Khởi Chiếu: 19.05.2023"));
        videos.add(new VIDEO(R.drawable.video3, "INSIDIOUS 5 Final Trailer - KC: 07.07.2023"));
        videos.add(new VIDEO(R.drawable.video4, "TÀ CHÚ CẤM - Main Trailer | Khởi chiếu: 23.06.2023"));
        videos.add(new VIDEO(R.drawable.video5, "NINJA RÙA: HỖN LOẠN TUỔI DẬY THÌ | Trailer G | Dự Kiến Khởi Chiếu: 01.09.2023"));
        videos.add(new VIDEO(R.drawable.video6, "Bé Trứng: Náo Loạn Châu Phi trailer - KC: 09.06.2023"));
        videos.add(new VIDEO(R.drawable.video7, "THE FLASH (tựa Việt: FLASH) - Final Trailer | KC: 16.06.2023"));

        VideosAdapter videosAdapter = new VideosAdapter(this, videos);
        rv_videos.setAdapter(videosAdapter);
        rv_videos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    public void setKenhCine(){
        ArrayList<KENHCINE> kenhcines = new ArrayList<>();
        kenhcines.add(new KENHCINE(R.drawable.kenh1, "Dự án phim ngắn CJ 2023 công bố Top 14 dự án vào vòng thuyết trình"));
        kenhcines.add(new KENHCINE(R.drawable.kenh2, "5 lý do khiến ‘Shazam! Cơn Thịnh Nộ Của Các Vị Thần’ là tác phẩm đáng xem nhất nhì của DC trong năm nay?"));
        kenhcines.add(new KENHCINE(R.drawable.kenh3, "Avatar 2 khẳng định trải nghiệm tại rạp là không thể thay thế"));
        kenhcines.add(new KENHCINE(R.drawable.kenh4, "Khán giả TP.HCM xếp hàng trước quầy vé CGV SC Vivo City dịp cuối tuần"));
        kenhcines.add(new KENHCINE(R.drawable.kenh2, "5 lý do khiến ‘Shazam! Cơn Thịnh Nộ Của Các Vị Thần’ là tác phẩm đáng xem nhất nhì của DC trong năm nay?"));
        kenhcines.add(new KENHCINE(R.drawable.kenh1, "Dự án phim ngắn CJ 2023 công bố Top 14 dự án vào vòng thuyết trình"));
        kenhcines.add(new KENHCINE(R.drawable.kenh4, "Khán giả TP.HCM xếp hàng trước quầy vé CGV SC Vivo City dịp cuối tuần"));

        KenhCineAdapter kenhCineAdapter = new KenhCineAdapter(this, kenhcines);
        rv_kenhcine.setAdapter(kenhCineAdapter);
        rv_kenhcine.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    public void setUudai(){
        viewPager2Uudai.setOffscreenPageLimit(3);
        viewPager2Uudai.setClipToPadding(false);
        viewPager2Uudai.setClipChildren(false);

        list = getListSlide();
        SlideAdapter slideAdapter = new SlideAdapter(this,list);
        viewPager2Uudai.setAdapter(slideAdapter);

        viewPager2Uudai.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 3000);
            }
        });
    }

    public List<SLIDE> getListSlide(){
        list = new ArrayList<>();
        list.add(new SLIDE(R.drawable.tin10));
        list.add(new SLIDE(R.drawable.tin11));
        list.add(new SLIDE(R.drawable.slide2));
        list.add(new SLIDE(R.drawable.tin12));
        list.add(new SLIDE(R.drawable.tin13));
        list.add(new SLIDE(R.drawable.tin14));
        list.add(new SLIDE(R.drawable.tin9));

        return list;

    }

    public void settextcolortablayout(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        Menu menu = toolbar.getMenu();

        AppBarLayout appBarLayout = findViewById(R.id.app);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.BaseOnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange()) {
                    // Đã thu gọn
                    // Thêm mã của bạn ở đây để xử lý sự kiện thu gọn
                    toolbar.setLogo(R.drawable.logo);
                    if (menu.findItem(R.id.menuID) != null || menu.findItem(R.id.ticketID) != null) {
                        MenuItem menuItem = menu.findItem(R.id.menuID);
                        MenuItem ticketItem = menu.findItem(R.id.ticketID);
                        // Đổi biểu tượng của mục menu thành biểu tượng mới
                        menuItem.setIcon(R.drawable.menured);
                        ticketItem.setIcon(R.drawable.ticketsred);
                    } else {
                        // Xử lý trường hợp mục menu không tồn tại
                    }
                    tabLayout.setTabTextColors(Color.parseColor("#FF018786"),Color.parseColor("#FF000000"));
                } else if (verticalOffset == 0) {
                    // Đã mở rộng
                    toolbar.setLogo(R.drawable.logowhite);
                    if (menu.findItem(R.id.menuID) != null || menu.findItem(R.id.ticketID) != null) {
                        MenuItem menuItem = menu.findItem(R.id.menuID);
                        MenuItem ticketItem = menu.findItem(R.id.ticketID);
                        // Đổi biểu tượng của mục menu thành biểu tượng mới
                        menuItem.setIcon(R.drawable.menuwhite);
                        ticketItem.setIcon(R.drawable.ticketswhite);
                    } else {
                        // Xử lý trường hợp mục menu không tồn tại
                    }
                    tabLayout.setTabTextColors(Color.parseColor("#FF03DAC5"),Color.parseColor("#FFFFFFFF"));
                } else {
                    // Ở giữa đâu đó
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                if (isHasUser){
                    Intent intentThanhvien = new Intent(MainActivity.this, ThanhVien.class);
                    startActivity(intentThanhvien);
                }else {
                    Intent intentUudai = new Intent(MainActivity.this, Uudai.class);
                    startActivity(intentUudai);
                }
                return true;
            case R.id.ticketID:
                if (isHasUser){
                    Intent intentlve = new Intent(MainActivity.this, VeCuaToi.class);
                    startActivity(intentlve);
                }else {
                    Intent intentlogin = new Intent(MainActivity.this, Login.class);
                    startActivity(intentlogin);
                }
                break;
            case R.id.menuID:
//                Toast.makeText(getApplication(), "menu", Toast.LENGTH_SHORT).show();
                drawerLayout.openDrawer(GravityCompat.END);
                break;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable, 3000);
    }
}