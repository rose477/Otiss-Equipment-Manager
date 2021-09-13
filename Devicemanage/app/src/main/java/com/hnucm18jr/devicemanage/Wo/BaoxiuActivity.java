package com.hnucm18jr.devicemanage.Wo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.hnucm18jr.devicemanage.R;
import com.hnucm18jr.devicemanage.Type.Atmostfragment;
import com.hnucm18jr.devicemanage.Type.Idledevices;
import com.hnucm18jr.devicemanage.Type.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

public class BaoxiuActivity extends AppCompatActivity {
    private List<Fragment> fragmentList = new ArrayList<>();
    private ViewPager viewPager;
    private TabLayout tabLayout;
    ImageView mImageView;
    int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_baoxiu);
        mImageView=findViewById(R.id.back);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent=getIntent();
        String tmp = intent.getStringExtra("type");
        result = Integer.valueOf(tmp);
        initData();
        //第一步：初始化ViewPager并设置adapter
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyViewPagerAdapter2(getSupportFragmentManager(), fragmentList));
        viewPager.setCurrentItem(result);

        //第二步：初始化Tablayout，给ViewPager设置标题（选项卡）
        tabLayout = (TabLayout) findViewById(R.id.tablayout);


        tabLayout.addTab(tabLayout.newTab().setText("待审核"));//添加tab选项卡
        tabLayout.addTab(tabLayout.newTab().setText("维修中"));
        tabLayout.addTab(tabLayout.newTab().setText("求购中"));
        tabLayout.addTab(tabLayout.newTab().setText("已反馈"));

        //第三步：关联ViewPager
        tabLayout.setupWithViewPager(viewPager);


        //在关联ViewPager之后添加如下代码，前三步不用更改
        tabLayout.getTabAt(0).setText("待审核");
        tabLayout.getTabAt(1).setText("维修中");
        tabLayout.getTabAt(2).setText("求购中");
        tabLayout.getTabAt(3).setText("已反馈");


    }
    private void initData() {
        fragmentList.add(new X1Fragment());
        fragmentList.add(new X2Fragment());
        fragmentList.add(new X3Fragment());
        fragmentList.add(new X4Fragment());
    }
    }
