package com.hnucm18jr.devicemanage.Type;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hnucm18jr.devicemanage.Main.Allsb;
import com.hnucm18jr.devicemanage.Main.AllsbAdapter;
import com.hnucm18jr.devicemanage.R;

import java.util.ArrayList;
import java.util.List;


public class RecommendFragment extends Fragment {
    RecyclerView mRecyclerView;
    List<Allsb> datas;
    AllsbAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = View.inflate(getActivity(), R.layout.fragment_recommend, null);

        mRecyclerView= view.findViewById(R.id.recyle1);
        //模拟数据
        datas = new ArrayList<>();
        String  a[]={"雷蛇键盘","雷蛇鼠标","雷神显示屏","惠普笔记本","惠普散热器","惠普打印机","戴尔电脑","戴尔笔记本"};
        int b[]={
                R.drawable.tuijian1,R.drawable.tuijian2,R.drawable.tuijian3,R.drawable.tuijian4,R.drawable.tuijian5,R.drawable.tuijian6,R.mipmap.dianzi6,R.drawable.tuijian3,
        };
        Allsb allsb;
        for (int i = 0; i < 8; i++) {
            allsb= new Allsb();
            allsb.setId(i);
            allsb.setName(a[i]);
            allsb.setImage(b[i]);
            datas.add(allsb);


        }
        //创建布局管理
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        //创建适配器
        adapter = new AllsbAdapter(R.layout.shebei_item, datas);

        //给RecyclerView设置适配器
        mRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return view;
    }


}