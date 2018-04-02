package com.example.amr.reviewallcustom.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.amr.reviewallcustom.R;
import com.example.amr.reviewallcustom.model.ModelList;

import java.util.ArrayList;

public class Custom extends ArrayAdapter<ModelList> {

    Context context;
    public Custom(@NonNull Context context,  @NonNull ArrayList<ModelList> objects) {
        super(context, 0, objects);
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ModelList modelList = getItem(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.layout_row , parent , false );
        TextView textView1 =  convertView.findViewById(R.id.text1);
        TextView textView2 = convertView.findViewById(R.id.text2);
        ImageView imageView = convertView.findViewById(R.id.img);

        textView1.setText(modelList.getText1());
        textView2.setText(modelList.getText2());
        imageView.setImageResource(modelList.getImage());

        return convertView;
    }
}
