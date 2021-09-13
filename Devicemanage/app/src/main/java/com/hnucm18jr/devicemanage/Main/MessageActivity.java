package com.hnucm18jr.devicemanage.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hnucm18jr.devicemanage.R;
import com.hnucm18jr.devicemanage.Wo.Tuijian;
import com.hnucm18jr.devicemanage.Wo.TuijianAdapter;
import com.hnucm18jr.devicemanage.sao.ShebeiActivity;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<Message> datas3;
    Messagedapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_message);
        mRecyclerView=findViewById(R.id.message);
        //  Log.i("clike",""+i);
        datas3 = new ArrayList<>();
        String  a[]={"周二吕","设备管理员"};
        String  b[]={"唐小波您好，我可以借用您的雷蛇显示器吗？","唐小波您好，您惠普电脑已维修完成"};
        String  c1[]={"同意","收到"};
        String  d[]={"拒绝","查看"};
        String  e[]={"3分钟前","昨天18:26"};
        int c[]={
                R.mipmap.headz,R.mipmap.logo4
        };
        Message message;
        for (int i = 0; i < 2; i++) {
            message= new Message();
            message.setName(a[i]);
            message.setContent(b[i]);
            message.setHead(c[i]);
            message.setAgree(c1[i]);
            message.setRefuse(d[i]);
            message.setTime(e[i]);

            datas3.add(message);


        }
        //创建布局管理
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));//可以表述一行显示item的数量，并且可以设置列表的方向

        //创建适配器
        adapter = new Messagedapter(R.layout.message_item, datas3);

        //给RecyclerView设置适配器
        mRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //设置重复执行动画
        adapter.isFirstOnly(false);

        //条目子控件点击事件
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

                datas3.remove(0);
                adapter.notifyDataSetChanged();
                    Toast.makeText(MessageActivity.this, "转借成功", Toast.LENGTH_SHORT).show();



            }
        });


    }
}