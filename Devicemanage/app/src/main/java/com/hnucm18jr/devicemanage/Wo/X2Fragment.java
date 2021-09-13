package com.hnucm18jr.devicemanage.Wo;

import android.os.Bundle;

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


public class X2Fragment extends Fragment {
    RecyclerView mRecyclerView;
    List<Allsb> datas;
    AllsbAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = View.inflate(getActivity(), R.layout.fragment_x2, null);

        mRecyclerView= view.findViewById(R.id.recyler4);
        //模拟数据
        datas = new ArrayList<>();
        String  a[]={"雷蛇键盘","雷蛇显示屏"};
        int b[]={
                R.drawable.tuijian1,R.drawable.tuijian3
        };
        String  c[]={"JP_2021_6879","DZ_2021_6866"};
        Allsb allsb;
        for (int i = 0; i < 2; i++) {
            allsb= new Allsb();
            allsb.setId(i);
            allsb.setName( a[i]);
            allsb.setImage(b[i]);
            allsb.setNum(c[i]);
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