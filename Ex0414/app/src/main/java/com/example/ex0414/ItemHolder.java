package com.example.ex0414;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemHolder {
    private TextView pro_name;
    private TextView pro_count;
    private ImageView img;
    private Button btn_product;

    public ItemHolder(View itemView){
        img = itemView.findViewById(R.id.img);
        pro_name = itemView.findViewById(R.id.pro_name);
        pro_count = itemView.findViewById(R.id.pro_count);
        btn_product = itemView.findViewById(R.id.btn_product);
    }

    public ImageView getImg() { return img; }

    public TextView getPro_name() {
        return pro_name;
    }

    public TextView getPro_count() {
        return pro_count;
    }

    public Button getBtn_product() {
        return btn_product;
    }
}

