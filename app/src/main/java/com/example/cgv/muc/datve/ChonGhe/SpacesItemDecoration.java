package com.example.cgv.muc.datve.ChonGhe;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public SpacesItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        if (position == 7 || position == 8 || position == 9 || position == 10 || position == 11 || position == 12 || position == 13) {
            outRect.right = space;
        }
        if (position == 42 || position == 43 || position == 44 || position == 45 || position == 46 || position == 47 || position == 48) {
            outRect.left = space;
        }
    }
}
