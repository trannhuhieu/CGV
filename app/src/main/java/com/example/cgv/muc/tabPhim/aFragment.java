package com.example.cgv.muc.tabPhim;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Parcelable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.cgv.R;
import com.example.cgv.SERVER;
import com.example.cgv.muc.datve.phim.Datve_phim;
import com.example.cgv.muc.datve.theophim.Datve_theophim;
import com.example.cgv.muc.datve.theorap.Datve_theorap;
import com.example.cgv.muc.login.Login;
import com.example.cgv.muc.login.User;
import com.example.cgv.muc.phim.adapter.PHIM;
import com.example.cgv.muc.phim.adapter.PhimAdapter;
import com.example.cgv.muc.phim.adapter.TTAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class aFragment extends Fragment {

    private ViewPager2 viewPager2;
    private ArrayList<PHIM> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private ArrayList<PHIM> listtt;
    private TextView btndatve;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        viewPager2 = view.findViewById(R.id.phim);
        recyclerView = view.findViewById(R.id.ten_thoigian);
        btndatve = view.findViewById(R.id.btndatve);
        //setting
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        //animation
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float i = 1 - Math.abs(position);
                page.setScaleY(0.85f + i * 0.15f);
                page.setRotationY(-15 * position);
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);
        list = getListPhim();
        PhimAdapter phimAdapter = new PhimAdapter(list, getContext());
        viewPager2.setAdapter(phimAdapter);

        listtt = (ArrayList<PHIM>) getListPhim();


        TTAdapter ttAdapter = new TTAdapter(listtt, getContext());
        recyclerView.setAdapter(ttAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                recyclerView.scrollToPosition(position);
            }
        });

        btndatve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFeedBackDiaLog(Gravity.BOTTOM);
            }
        });

        return view;
    }
//    private void LoadMovies(){
//        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
//        com.android.volley.Response.Listener<JSONArray> thanhcong = new com.android.volley.Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray jsonArray) {
//                for(int i = 0; i < jsonArray.length(); i++)
//                {
//                    try
//                    {
//                        JSONObject jsonObject = jsonArray.getJSONObject(i);
//                        list.add(new PHIM(jsonObject.getString("movie_id"),
//                                jsonObject.getString("moive_name"),
//                                jsonObject.getString("release_time"),
//                                jsonObject.getString("movie_content"),
//                                jsonObject.getString("content_censorship"),
//                                jsonObject.getString("movie_genre"),
//                                jsonObject.getString("language"),
//                                jsonObject.getString("movie_images")));
//                    }catch (JSONException e)
//                    {
//                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        };
//        com.android.volley.Response.ErrorListener thatbai = new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getContext(), "error.getMessage()", Toast.LENGTH_SHORT).show();
//            }
//        };
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(SERVER.moviespath, thanhcong, thatbai);
//        requestQueue.add(jsonArrayRequest);
//
//        PhimAdapter phimAdapter = new PhimAdapter(list, getContext());
//        viewPager2.setAdapter(phimAdapter);
//    }

    public ArrayList<PHIM> getListPhim(){
        list = new ArrayList<>();
        list.add(new PHIM(R.drawable.phim1,
                "Transformers: quái thú trỗi dậy",
                "2giờ 20phút 01thg 6 2023",
                "Bộ phim dựa trên sự kiện Beast Wars trong loạt phim hoạt hình Transformers, nơi mà các robot có khả năng biến thành động vật khổng lồ cùng chiến đấu chống lại một mối đe dọa tiềm tàng.",
                "13+",
                "Hành động",
                "Tiếng Anh - Phụ đề tiếng Việt; Lồng Tiếng"));
        list.add(new PHIM(R.drawable.nen5,
                "Người nhện: Du hành vũ trụ nhện",
                "2giờ 20phút 01thg 6 2023",
                "Miles Morales tái xuất trong phần tiếp theo của bom tấn hoạt hình từng đoạt giải Oscar - Spider-Man: Across the Spider-Verse. Sau khi gặp lại Gwen Stacy, chàng Spider-Man thân thiện đến từ Brooklyn...",
                "13+",
                "Hành động",
                "Tiếng Anh - Phụ đề tiếng Việt; Lồng Tiếng"));
        list.add(new PHIM(R.drawable.nen2,
                "Phim điện ảnh Doremon: Nobita và vùng đất bí ẩn",
                "1giờ 48phút 26thg 05 2023",
                "Phim điện ảnh Doraemon: Nobita Và Vùng Đất Lý Tưởng Trên Bầu Trời kể câu chuyện khi Nobita tìm thấy một hòn đảo hình lưỡi liềm trên trời mây. Ở nơi đó, tất cả đều hoàn hảo… đến mức cậu nhóc Nobita mê ",
                "13+",
                "Hành động",
                "Tiếng Anh - Phụ đề tiếng Việt; Lồng Tiếng"));
        list.add(new PHIM(R.drawable.phim3,
                "Fast and Furious X",
                "2giờ 22phút 19thg 05 2023",
                "Dom Toretto và gia đình của anh ấy bị trở thành mục tiêu của người con trai đầy thù hận của ông trùm ma túy Hernan Reyes.",
                "13+",
                "Hành động",
                "Tiếng Anh - Phụ đề tiếng Việt; Lồng Tiếng"));
        list.add(new PHIM(R.drawable.phim4,
                "Hoon payon: Bùa hình nhân",
                "2giờ 22phút 19thg 05 2023",
                "Hoon payon xoay quanh người đàn ông bí ẩn được biết đến với tên gọi “Hoon payon”. Gã đột nhiên xuất hiện trước mắt Marco, một thanh niên người Philippines mơ ước trở thành vận động viên boxing chuyên nghiệp, lang thang khắp các sàn đấu bất hợp pháp tại đây.",
                "13+",
                "Hành động",
                "Tiếng Anh - Phụ đề tiếng Việt; Lồng Tiếng"));

        return list;

    }

    private void openFeedBackDiaLog(int gravity){
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_datve);


        Window window = dialog.getWindow();
        if (window == null)
            return;

        window.setWindowAnimations(R.style.MyDialoAnimation);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams winLayoutParams = window.getAttributes();
        winLayoutParams.gravity = gravity;
        window.setAttributes(winLayoutParams);

        dialog.setCancelable(true);
        dialog.show();

        TextView phim, rap, theophim, huy;
        phim = dialog.findViewById(R.id.phim);
        rap = dialog.findViewById(R.id.theorap);
        theophim = dialog.findViewById(R.id.theophim);
        huy = dialog.findViewById(R.id.huy);

        phim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewPager2.getCurrentItem();
                PhimAdapter phimAdapter = (PhimAdapter) viewPager2.getAdapter();
                PHIM phim1 = phimAdapter.getData(position);
                Intent intent = new Intent(getContext(), Datve_phim.class);
                String ten = phim1.getTen();
                int hinh = phim1.getId();
                intent.putExtra("TEN", ten);
                intent.putExtra("HINH", hinh);
//                dialog.dismiss();
                startActivity(intent);
                dialog.dismiss();
            }
        });

        rap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext(), "phim", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), Datve_theorap.class);
//                dialog.dismiss();
                startActivity(intent);
                dialog.dismiss();
            }
        });

        theophim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext(), "phim", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), Datve_theophim.class);
//                dialog.dismiss();
                startActivity(intent);
                dialog.dismiss();
            }
        });

        huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}