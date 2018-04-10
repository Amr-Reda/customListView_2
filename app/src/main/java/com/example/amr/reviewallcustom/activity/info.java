package com.example.amr.reviewallcustom.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.amr.reviewallcustom.R;
import com.example.amr.reviewallcustom.adapter.Custom;
import com.example.amr.reviewallcustom.db.SQLite;
import com.example.amr.reviewallcustom.model.ModelList;

import java.util.ArrayList;

public class info extends AppCompatActivity {

    ListView listView ;
    ArrayList<ModelList> arrayList;
    Custom custom;
    SQLite sqLite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info2);

        listView = findViewById(R.id.list);
        arrayList = new ArrayList<>();

        sqLite = new SQLite(info.this);
        arrayList = sqLite.allBooks();
        custom = new Custom(info.this , arrayList);

        listView.setAdapter(custom);



    }
}
