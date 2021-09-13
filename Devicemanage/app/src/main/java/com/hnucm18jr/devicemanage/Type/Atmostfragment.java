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

public class Atmostfragment extends Fragment {

    RecyclerView mRecyclerView;
    List<Allsb> datas;
    AllsbAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = View.inflate(getActivity(), R.layout.fragment_atmostfragment, null);

        mRecyclerView= view.findViewById(R.id.recyle);
        datas = new ArrayList<>();
        String  a[]={"惠普电脑","红米手机","三星平板","萤石监控摄像头","小米电子黑板","戴尔电脑","戴尔笔记本","雷神显示屏"};
        int b[]={
                R.drawable.tuijian4,R.mipmap.dianzi1,R.mipmap.dianzi2,R.mipmap.dianzi3,R.mipmap.dianzi4,R.mipmap.dianzi5,R.mipmap.dianzi6,R.drawable.tuijian3,
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