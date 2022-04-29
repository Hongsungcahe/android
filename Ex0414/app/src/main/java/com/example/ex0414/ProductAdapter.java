package com.example.ex0414;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;


public class ProductAdapter extends BaseAdapter {
    Context context;
    int item_layout;
    ArrayList<ProductVO> list;
    LayoutInflater inflater;
    public ProductAdapter(Context context, int item_layout, ArrayList<ProductVO> list) {
        this.context = context;
        this.item_layout = item_layout;
        this.list = list;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    //선택한 인덱스의 내용물?
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    //선택한 인덱스를 반환하는 부분
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ItemHolder holder = null;

        if(view ==null){
            view = inflater.inflate(item_layout, viewGroup, false);
            holder = new ItemHolder(view);

            view.setTag(holder);
        }else{
            holder = (ItemHolder) view.getTag();
        }
        ProductVO vo = (ProductVO) getItem(i);
        holder.getImg().setImageResource(vo.getImg());
        holder.getPro_name().setText(vo.getName());
        holder.getPro_count().setText(vo.getProcount());

        holder.getBtn_product().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //대화상자 : AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("상품 보기").setMessage("상품개수 : "+vo.getProcount()).setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

                Toast.makeText(context,vo.getName(),Toast.LENGTH_SHORT).show();


            }
        });

        return view; //젤 중요
    }
}
