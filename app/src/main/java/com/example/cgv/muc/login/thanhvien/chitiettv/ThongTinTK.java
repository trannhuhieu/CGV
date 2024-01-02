package com.example.cgv.muc.login.thanhvien.chitiettv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cgv.MainActivity;
import com.example.cgv.R;

public class ThongTinTK extends AppCompatActivity {

    TextView btnXacnhan;
    EditText edtRetype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_tk);

        btnXacnhan = findViewById(R.id.btnXacnhan);
        edtRetype = findViewById(R.id.edt_retypePassword);

        intiToolbar();

        btnXacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtRetype.getText().toString() == null){
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập mật khẩu", Toast.LENGTH_LONG).show();
                    edtRetype.setText(null);
                }else{
                    if (edtRetype.getText().toString().equals(MainActivity.mUser.getPassword())){
                        Intent intent = new Intent(getApplicationContext(), ShowInformation.class);
                        edtRetype.setText(null);
                        startActivity(intent);

                    }else {
                        Toast.makeText(getApplicationContext(), "Vui lòng nhập lại mật khẩu", Toast.LENGTH_LONG).show();
                        edtRetype.setText(null);
                    }
                }
            }
        });
    }

    private void intiToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbarthongtin);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_phim, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menuPhim:
                Toast.makeText(getApplicationContext(), "Menu", Toast.LENGTH_SHORT).show();
                return true;

            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}