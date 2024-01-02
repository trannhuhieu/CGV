package com.example.cgv.muc.tabPhim;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.cgv.R;
import com.example.cgv.muc.phim.adapter.PHIM;
import com.example.cgv.muc.phim.adapter.PhimAdapter;
import com.example.cgv.muc.phim.adapter.TTAdapter;
import java.util.ArrayList;
import java.util.List;

public class cFragment extends Fragment {

    private ViewPager2 viewPager2;
    private List<PHIM> list;
    private RecyclerView recyclerView;
    private ArrayList<PHIM> listtt;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_c, container, false);

        viewPager2 = view.findViewById(R.id.phim);
        recyclerView = view.findViewById(R.id.ten_thoigian);

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

        return view;
    }

    public List<PHIM> getListPhim(){
        list = new ArrayList<>();
        list.add(new PHIM(R.drawable.phim5, "flash", "2giờ 20phút 01thg 6 2023", "Spiderman", "13+", "Hành động", "Tiếng Anh - Phụ đề tiếng Việt; Lồng Tiếng"));
        list.add(new PHIM(R.drawable.phim6, "Mavka: thần thoại rừng xanh", "1giờ 48phút 26thg 05 2023", "Doremon", "13+", "Hành động", "Tiếng Anh - Phụ đề tiếng Việt; Lồng Tiếng"));
        list.add(new PHIM(R.drawable.phim3, "Fast and Furious X", "2giờ 22phút 19thg 05 2023", "Fast and Furious", "13+", "Hành động", "Tiếng Anh - Phụ đề tiếng Việt; Lồng Tiếng"));
        list.add(new PHIM(R.drawable.nen5, "Người nhện: Du hành vũ trụ nhện", "2giờ 20phút 01thg 6 2023", "Spiderman", "13+", "Hành động", "Tiếng Anh - Phụ đề tiếng Việt; Lồng Tiếng"));
        list.add(new PHIM(R.drawable.phim3, "Fast and Furious X", "2giờ 22phút 19thg 05 2023", "Fast and Furious", "13+", "Hành động", "Tiếng Anh - Phụ đề tiếng Việt; Lồng Tiếng"));
        list.add(new PHIM(R.drawable.nen2, "Phim điện ảnh Doremon: Nobita và vùng đất bí ẩn", "1giờ 48phút 26thg 05 2023", "Spiderman", "13+", "Hành động", "Tiếng Anh - Phụ đề tiếng Việt; Lồng Tiếng"));
        list.add(new PHIM(R.drawable.nen5, "Người nhện: Du hành vũ trụ nhện", "2giờ 20phút 01thg 6 2023", "Doremon", "13+", "Hành động", "Tiếng Anh - Phụ đề tiếng Việt; Lồng Tiếng"));
        return list;

    }

}