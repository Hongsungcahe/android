package com.example.ex0414;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//어댑터의 역할
// 1. 리스트 뷰에 보여질 아이템 뷰를 생성해주는 역할
// 2. 아이템 뷰와 데이터를 묶어서 View 객체로 생성

public class ContactAdapter extends BaseAdapter {
    Context context;
    //R.~~~ 는 정수형으로 변환시켜준다고 생각하면 된다.
    int layout;
    //여러형태의 데이터를 담기때문에
    ArrayList<ContactVO> list;

    //xml 파일 -> View 객체로 변환해주는 객체, 중요
    LayoutInflater inflater;

    public ContactAdapter(Context context, int layout, ArrayList<ContactVO> list) {
        this.context = context;
        this.layout = layout;
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
    //직접적으로 구현해야되는 부분
    // i는 인덱스 역할, view는 layout에 대한 정보를 보관해줄 객체, ViewGroup은 리스트 뷰 어뎁터
    public View getView(int i, View view, ViewGroup viewGroup) {
        //아이템 뷰에 배치된 View객체들을 한 번 초기화
        ViewHolder holder = null;

        // list_item.xml -> View 객체로 변환
        if(view ==null){
            view = inflater.inflate(layout, viewGroup, false);
            holder = new ViewHolder(view);

            //초기화된 holder 객체를 view객체에 태그로 저장,setTag는 저장시키는 것
            view.setTag(holder);
        }else{
            //view객체에 저장된 holder객체를 가져와서 저장장
           holder = (ViewHolder) view.getTag();
        }

        ContactVO vo = (ContactVO) getItem(i);
        holder.getImageView().setImageResource(vo.getImg());
        holder.getTvName().setText(vo.getName());
        holder.getTvPhone().setText(vo.getPhone());

        holder.getBtnCall().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //context = ContactActivity를 가리킴
                Toast.makeText(context,vo.getPhone(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,MainActivity.class);
                //ContactAdapter는 액티비티가 아닌 일반클래스이기 때문에
                //액티비티에서만 사용할 수 있는 메소드를 바로 호출이 불가능
                // 사용하려면 액티비티 정보를 가진 Context 객체를 통해서 사용가능!
                context.startActivity(intent);

            }
        });



        //생성된 Layout View객체를 리턴 -> listView에 출력
        return view; //젤 중요
    }
}
