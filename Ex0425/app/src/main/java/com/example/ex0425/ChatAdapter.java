package com.example.ex0425;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<ChatVO> list;
    LayoutInflater inflater; // xml-> view로 변환
    String currentId;

    public ChatAdapter(Context context, int layout, ArrayList<ChatVO> list, String currentId) {
        this.context = context;
        this.layout = layout;
        this.list = list;
        this.currentId = currentId;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE); // 절대 변하지 않음
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) { //i는 위치, view - layout의 정보, viewGroup - 부모 레이아웃(Listview)
        if(view == null){
            //view는 chat_item.xml 정보를 가진 객체
            view = inflater.inflate(layout,viewGroup,false); // 보여줄 layout 정보를 viewGroup(listview)에 합친다라고 생각
        }

        ImageView imgOther= view.findViewById(R.id.imgOther);
        TextView tvOtherNm = view.findViewById(R.id.tvOtherNm);
        TextView tvOtherMsg = view.findViewById(R.id.tvOtherMsg);
        TextView tvOtherTime = view.findViewById(R.id.tvOtherTime);
        TextView tvMyMsg = view.findViewById(R.id.tvMyMsg);
        TextView tvMyTime = view.findViewById(R.id.tvMyTime);

        ChatVO vo = list.get(position);

        //현재 로그인한 아이디 판단
        //상대방 id인 경우 왼쪽 view만 보여지도록 설정(imgOther, tvOtherMsg~~)
        //자신의 id인 경우 오른쪽 view만 보여지도록 설정(tvMyMSG, tvMyTime)
        if(list.get(position).getName().equals(currentId)){
            imgOther.setVisibility(View.INVISIBLE);
            tvOtherNm.setVisibility(View.INVISIBLE);
            tvOtherMsg.setVisibility(View.INVISIBLE);
            tvOtherTime.setVisibility(View.INVISIBLE);

            tvMyMsg.setVisibility(View.VISIBLE);
            tvMyTime.setVisibility(View.VISIBLE);

            tvMyMsg.setText(vo.getMsg());
            tvMyTime.setText(vo.getTime());
        }else{
            imgOther.setVisibility(View.VISIBLE);
            tvOtherNm.setVisibility(View.VISIBLE);
            tvOtherMsg.setVisibility(View.VISIBLE);
            tvOtherTime.setVisibility(View.VISIBLE);

            tvMyMsg.setVisibility(View.INVISIBLE);
            tvMyTime.setVisibility(View.INVISIBLE);

            imgOther.setImageResource(vo.getImgId());
            tvOtherNm.setText(vo.getName());
            tvOtherMsg.setText(vo.getMsg());
            tvOtherTime.setText(vo.getTime());
        }




        return view;
    }
}
