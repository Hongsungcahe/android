package com.example.ex0414;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

//아이탬뷰에 배치된
public class ViewHolder {
    private ImageView imageView;
    private TextView tvName;
    private TextView tvPhone;
    private ImageButton btnCall;


    public ViewHolder(View itemView){
        imageView = itemView.findViewById(R.id.imageView2);
        btnCall = itemView.findViewById(R.id.call);
        tvName = itemView.findViewById(R.id.name);
        tvPhone = itemView.findViewById(R.id.phone);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTvName() {
        return tvName;
    }

    public TextView getTvPhone() {
        return tvPhone;
    }

    public ImageButton getBtnCall() {
        return btnCall;
    }
}
