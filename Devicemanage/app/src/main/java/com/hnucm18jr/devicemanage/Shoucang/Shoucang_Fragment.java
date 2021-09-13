package com.hnucm18jr.devicemanage.Shoucang;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.hnucm18jr.devicemanage.R;
import com.hnucm18jr.devicemanage.Wo.MyAdapter;
import com.hnucm18jr.devicemanage.sao.ShebeiActivity;

import java.util.ArrayList;
import java.util.List;


public class Shoucang_Fragment extends Fragment {



    RecyclerView recyclerView;
    List<sc_sth> datas3;
    sc_adapter adapter;

    TextView mTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shoucang_, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView=getActivity().findViewById(R.id.recyler_sc);//实例化
        mTextView=getActivity().findViewById(R.id.num);


        Thread thread = new Thread(){//方法1
            @Override
            public void run() {
                super.run();
                //子线程
                //模拟数据
                datas3 = new ArrayList<>();
                String  a[]={"惠普音响","会议麦克风","诺尔会议控制笔","极光投影仪","艾瑞尔投影仪幕布","惠普笔记本"};
                int b[]={
                        R.drawable.tuijian7,R.drawable.tuijian8,R.drawable.tuijian9,R.drawable.tuijian10,R.drawable.tuijian11,R.drawable.diannao6
                };
                String  c[]={"电子设备","会议演讲","会议演讲","办公设备","办公设备","电脑笔记"};
                String  d[]={"DZ_2221_6819","HY_2021_6866","HY_2021_6884","BG_2021_2219","BG_2021_3419","DN_2021_6749"};
                String  e[]={"空闲","在用","空闲","空闲","空闲","空闲"};
                sc_sth item;
                for (int i = 0; i < 5; i++) {
                    item= new sc_sth();
                    item.setId(""+(i+1));
                    item.setId2(d[i]+a[i]);
                    item.setIsnormal("普通设备");
                    item.setIsuse(e[i]);
                    item.setType(c[i]);

                    item.setHead(b[i]);
                    item.setName("");
                    datas3.add(item);


                }
                //创建布局管理
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(layoutManager);

                //创建适配器
                adapter = new sc_adapter(R.layout.sc_item, datas3);

                //给RecyclerView设置适配器
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                        Intent intent=new Intent(getActivity(), ShebeiActivity.class);
                        startActivity(intent);
                    }
                });
                //条目子控件点击事件
                adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                    @Override
                    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

                        Intent intent=new Intent(getActivity(), ShebeiActivity.class);
                        startActivity(intent);
                    }
                });

            }
        };
        thread.start();
        //item点击事件



    }


}