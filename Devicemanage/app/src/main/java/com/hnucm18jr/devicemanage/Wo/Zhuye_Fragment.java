package com.hnucm18jr.devicemanage.Wo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hnucm18jr.devicemanage.R;
import com.hnucm18jr.devicemanage.Main.SearchActivity;
import com.hnucm18jr.devicemanage.sao.ShebeiActivity;

import java.util.ArrayList;
import java.util.List;


public class Zhuye_Fragment extends Fragment {


    RecyclerView recyclerView;
    List<Shebei> datas= new ArrayList<>();;
    MyAdapter adapter;
    ImageView mImageView1,mImageView2,mImageView3,mImageView4;



    ConstraintLayout mConstraintLayout,mConstraintLayout2;
    SwipeRefreshLayout mSwipeRefreshLayout;
    private ArrayList<Integer> images = new ArrayList<>(); //设置数据源

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_zhuye_, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {


        super.onActivityCreated(savedInstanceState);
        recyclerView = getActivity().findViewById(R.id.recyler);//实例化

        mConstraintLayout2=getActivity().findViewById(R.id.con2);
        mSwipeRefreshLayout=getActivity().findViewById(R.id.swipe);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.main);
        mImageView1=getActivity().findViewById(R.id.imageView6);
        mConstraintLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),BuyActivity .class);

                startActivity(intent);
            }
        });
        mImageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),BaoxiuActivity.class);
                intent.putExtra("type","0");
                startActivity(intent);
            }
        });
        mImageView2=getActivity().findViewById(R.id.imageView5);
        mImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),BaoxiuActivity.class);
                intent.putExtra("type","1");
                startActivity(intent);
            }
        });
        mImageView3=getActivity().findViewById(R.id.imageView7);
        mImageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),BaoxiuActivity.class);
                intent.putExtra("type","2");
                startActivity(intent);
            }
        });
        mImageView4=getActivity().findViewById(R.id.imageView8);
        mImageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),BaoxiuActivity.class);
                intent.putExtra("type","3");
                startActivity(intent);
            }
        });

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                datas.clear();
                for (int i = 0; i < 5; i++) {
                    Shebei shebei=new Shebei();

                    datas.add(shebei);


                }
                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        datas = new ArrayList<>();


                        adapter.notifyDataSetChanged();
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });




        Thread thread = new Thread(){//方法1
            @Override
            public void run() {
                super.run();
                //子线程
                Shebei shebei;
                String  a[]={"雷蛇键盘","新越昌辉小推车","华为智选台灯","卡夫威尔螺丝刀","惠普散热器","华为智选台灯"};
                String  b[]={"1小时","1天","3天","5天","1个月","6个月"};
                int c[]={
                        R.drawable.tuijian1,R.drawable.bumen1,R.drawable.bumen2,R.drawable.bumen3,R.drawable.tuijian5,R.drawable.bumen2
                };
                for (int i = 0; i < 5; i++) {

                    shebei=new Shebei();
                    shebei.setName(a[i]);
                    shebei.setImage(c[i]);
                    shebei.setTime(b[i]+"后到期");
                    datas.add(shebei);


                }



                //创建布局管理
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));//可以表述一行显示item的数量，并且可以设置列表的方向


                //创建适配器
                adapter = new MyAdapter(R.layout.wode_item, datas);
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
            }
        };
        thread.start();

    }


}