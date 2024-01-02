package com.example.cgv.muc.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.cgv.MainActivity;
import com.example.cgv.R;
import com.example.cgv.SERVER;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {

    TextView btnregister;

    private EditText edtUsername, edtPassword;
    private Button btnLogin;

    private List<User> mListUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        intiToolbar();


        anhxa();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Load();
            }
        });

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
    }

    private void Load() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        com.android.volley.Response.Listener<JSONArray> thanhcong = new com.android.volley.Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                for(int i = 0; i < jsonArray.length(); i++)
                {
                    try
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        mListUser.add(new User(jsonObject.getString("user_id"),
                                jsonObject.getString("username"),
                                jsonObject.getString("password")));
                    }catch (JSONException e)
                    {
                        Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        };
        com.android.volley.Response.ErrorListener thatbai = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Login.this, "error.getMessage()", Toast.LENGTH_SHORT).show();
            }
        };
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(SERVER.userpath, thanhcong, thatbai);
        requestQueue.add(jsonArrayRequest);

        String strUsername = edtUsername.getText().toString().trim();
        String strPassword = edtPassword.getText().toString().trim();

        if (mListUser == null || mListUser.isEmpty()){
            return;
        }


        for (User user : mListUser){
            if(strUsername.equals(user.getUsername()) && strPassword.equals(user.getPassword())) {
                MainActivity.isHasUser = true;
                MainActivity.mUser = user;
                break;
            }
        }

        if (MainActivity.isHasUser){
            //Chuyển dữu liệu
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(Login.this, "Username or Password invalid", Toast.LENGTH_SHORT).show();
        }
    }

    private void anhxa() {
        edtUsername = findViewById(R.id.edtTaikhoan);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btn_login);
        mListUser = new ArrayList<>();
        btnregister = findViewById(R.id.tv_register);
    }

    private void intiToolbar(){
        Toolbar toolbarlogin = findViewById(R.id.toolbarlogin);

        setSupportActionBar(toolbarlogin);
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