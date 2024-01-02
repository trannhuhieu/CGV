package com.example.cgv.muc.login.thanhvien.chitiettv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.cgv.MainActivity;
import com.example.cgv.R;
import com.example.cgv.muc.login.Login;
import com.example.cgv.muc.login.thanhvien.ThanhVien;
import com.example.cgv.muc.uudai.Uudai;

public class ShowInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_information);


        intiToolbar();

    }

    private void intiToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbarsuatt);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.backwhite);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}