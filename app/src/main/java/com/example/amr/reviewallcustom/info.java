package com.example.amr.reviewallcustom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class info extends AppCompatActivity {
    TextView textInfo1;
    TextView textInfo2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info2);
        textInfo1=findViewById(R.id.textInfo1);
        textInfo2=findViewById(R.id.textInfo2);
        String s1=getIntent().getStringExtra("name");
        String s2=getIntent().getStringExtra("author");
        textInfo1.setText(s1);
        textInfo2.setText(s2);
    }
}
