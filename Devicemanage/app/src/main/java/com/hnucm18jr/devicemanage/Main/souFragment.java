package com.hnucm18jr.devicemanage.Main;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hnucm18jr.devicemanage.R;
import com.hnucm18jr.devicemanage.Wo.MyAdapter;

import org.xutils.BuildConfig;
import org.xutils.DbManager;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class souFragment extends Fragment {

    RecyclerView mRecyclerView,mRecyclerView2;
    List<Hotsth> datas;
    Find_adapter adapter;
    List<Historysth> datas2;
    History_adapter adapter2;
    DbManager.DaoConfig daoConfig = new DbManager.DaoConfig()
            .setDbName("history.db")
            // 不设置dbDir时, 默认存储在app的私有目录.
            // .setDbDir(new File("/sdcard")) // "sdcard"的写法并非最佳实践, 这里为了简单, 先这样写了.
            .setDbVersion(2)
            .setDbOpenListener(new DbManager.DbOpenListener() {
                @Override
                public void onDbOpened(DbManager db) {
                    // 开启WAL, 对写入加速提升巨大
                    db.getDatabase().enableWriteAheadLogging();
                }
            })
            .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                @Override
                public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                    // TODO: ...
                    // db.addColumn(...);
                    // db.dropTable(...);
                    // ...
                    // or
                    // db.dropDb();
                }
            });


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sou, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView=getActivity().findViewById(R.id.hoy_list);
        mRecyclerView2=getActivity().findViewById(R.id.history_list);

        x.Ext.init(getActivity().getApplication());
        x.Ext.setDebug(BuildConfig.DEBUG);// 是否输出debug日志, 开启debug会影响性能.
        x.view().inject(getActivity());//没有用到view注解可以先不用

        //模拟数据
        datas = new ArrayList<>();
        Hotsth hotsth;
        String a[]={"雷蛇键盘","惠普电脑","雷蛇鼠标","雷神显示屏","得力剪刀","台灯","投影仪","办公椅"};
        for (int i = 0; i < 8; i++) {
            hotsth= new Hotsth();
            hotsth.setHot(""+(i+1)+"\t\t"+a[i]);

            datas.add(hotsth);


        }
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));//可以表述一行显示item的数量，并且可以设置列表的方向



        //创建适配器
        adapter = new Find_adapter(R.layout.hot, datas);

        //给RecyclerView设置适配器
        mRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //模拟数据
        datas2 = new ArrayList<>();
        Historysth hotsth2= new Historysth();

        DbManager db = null;
        try {// 删除1
            db = x.getDb(daoConfig);
            List<Historysth> users = new ArrayList<>();
            users= db.selector(Historysth.class).findAll();
            if (users!=null){
                Collections.reverse(users);
                for (Historysth user : users){

                            datas2.add(user);


                    Log.i("testdb","test" + user);
                }
            }


        } catch (DbException e) {
            e.printStackTrace();
            return;
        }



        mRecyclerView2.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));//可以表述一行显示item的数量，并且可以设置列表的方向



        //创建适配器
        adapter2 = new History_adapter(R.layout.hot, datas2);

        //给RecyclerView设置适配器
        mRecyclerView2.setAdapter(adapter2);
        adapter2.notifyDataSetChanged();
    }
}