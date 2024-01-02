package com.example.cgv;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.cgv.muc.tabPhim.aFragment;
import com.example.cgv.muc.tabPhim.bFragment;
import com.example.cgv.muc.tabPhim.cFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {


    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new aFragment();
            case 1:
                return new bFragment();
            case 2:
                return new cFragment();
            default:
                return new aFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
