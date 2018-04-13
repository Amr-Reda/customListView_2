package com.example.amr.reviewallcustom.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
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

    Button deleteAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info2);

        listView = findViewById(R.id.list);
        deleteAll = findViewById(R.id.delete_all);
        arrayList = new ArrayList<>();

        sqLite = new SQLite(info.this);
        arrayList = sqLite.allBooks();
        custom = new Custom(info.this , arrayList);

        listView.setAdapter(custom);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                sqLite.deleteBook(arrayList.get(position).getId());
                arrayList.remove(position);
                custom.notifyDataSetChanged();
            }
        });

        deleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLite.deleteAll();
                arrayList.clear();
                custom.notifyDataSetChanged();
            }
        });



    }
}
