package com.example.amr.reviewallcustom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.amr.reviewallcustom.adapter.Custom;
import com.example.amr.reviewallcustom.model.ModelList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<ModelList> arrayList;
    Custom custom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);
        arrayList = new ArrayList<>();

        ModelList modelList = new ModelList();
        modelList.setText1("ONE");
        modelList.setText2("One Sub");
        modelList.setImage(R.drawable.ic_launcher_background);
        ModelList modelList2 = new ModelList();
        modelList2.setText1("TWO");
        modelList2.setText2("Two Sub");
        modelList2.setImage(R.drawable.ic_launcher_background);
        arrayList.add(modelList);
        arrayList.add(modelList2);

        custom = new Custom(MainActivity.this , arrayList);

        listView.setAdapter(custom);
    }
}
