package com.example.cgv.muc.uudai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cgv.MainActivity;
import com.example.cgv.R;
import com.example.cgv.muc.login.Login;
import com.example.cgv.muc.login.Register;
import com.example.cgv.muc.tintuc.tin.ChitietTin;

public class Uudai extends AppCompatActivity {

    TextView btnlogin, btnregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uudai);

        btnlogin = findViewById(R.id.login);
        btnregister = findViewById(R.id.register);

        intiToolbar();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Uudai.this, Login.class);
//                intent.putExtra("Login", getIntent().getBooleanExtra("User", false));
                startActivity(intent);
            }
        });

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Uudai.this, Register.class);
                startActivity(intent);
            }
        });
    }

    private void intiToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbarUudai);

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