package com.example.amr.reviewallcustom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amr.reviewallcustom.adapter.Custom;
import com.example.amr.reviewallcustom.model.ModelList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    TextView text_1;
    TextView text_2;
    Button btn;
    ArrayList<ModelList> arrayList;
    Custom custom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);
        text_1 =findViewById(R.id.editText1);
        text_2 =findViewById(R.id.editText2);
        btn =findViewById(R.id.btn1);

        arrayList = new ArrayList<>();

        ModelList modelList = new ModelList();
        modelList.setText1("ONE");
        modelList.setText2("One Sub");
        ModelList modelList2 = new ModelList();
        modelList2.setText1("TWO");
        modelList2.setText2("Two Sub");
        arrayList.add(modelList);
        arrayList.add(modelList2);

        custom = new Custom(MainActivity.this , arrayList);

        listView.setAdapter(custom);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=text_1.getText().toString();
                String author=text_2.getText().toString();
                ModelList modelL = new ModelList();
                modelL.setText1(name);
                modelL.setText2(author);
                arrayList.add(modelL);
                custom.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,name+" Added",Toast.LENGTH_LONG).show();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayList.remove(position);
                custom.notifyDataSetChanged();
                return false;

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,info.class);
                intent.putExtra("name",arrayList.get(position).getText1());
                intent.putExtra("author",arrayList.get(position).getText2());
                startActivity(intent);

            }
        });
    }
}
