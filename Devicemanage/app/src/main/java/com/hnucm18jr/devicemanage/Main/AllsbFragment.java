package com.hnucm18jr.devicemanage.Main;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hnucm18jr.devicemanage.R;

import java.util.ArrayList;
import java.util.List;


public class AllsbFragment extends Fragment {

    RecyclerView mRecyclerView;
    List<Allsb> datas;
    AllsbAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_allsb, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView=getActivity().findViewById(R.id.allrecyler);
        //模拟数据
        datas = new ArrayList<>();
        Allsb allsb;
        String  a[]={"惠普台式电脑","惠普笔记本","惠普台式电脑","惠普台式电脑","惠普笔记本","惠普台式电脑","惠普笔记本","惠普机箱","惠普散热器"};
        int b[]={
                R.drawable.diannao1,R.drawable.diannao2,R.drawable.diannao3,R.drawable.diannao4,R.drawable.diannao6,R.drawable.diannao7,R.drawable.tuijian4,R.drawable.diannao5,R.drawable.tuijian5
        };
        for (int i = 0; i < 9; i++) {
            allsb= new Allsb();
            allsb.setId(i);
            allsb.setName( a[i]);
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

    }
}