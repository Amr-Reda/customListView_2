package com.example.amr.reviewallcustom.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.amr.reviewallcustom.R;

public class login extends AppCompatActivity {
Button btn;
EditText email,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn =findViewById(R.id.btn);
        email =findViewById(R.id.email);
        pass =findViewById(R.id.password);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
