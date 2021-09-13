package com.hnucm18jr.devicemanage.Type;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.hnucm18jr.devicemanage.R;

import java.util.ArrayList;
import java.util.List;

public class TypeActivity extends AppCompatActivity {
    private List<Fragment> fragmentList = new ArrayList<>();
    private ViewPager viewPager;
    private TabLayout tabLayout;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_type2);
        mImageView=findViewById(R.id.back);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initData();
        //第一步：初始化ViewPager并设置adapter
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager(), fragmentList));
        viewPager.setCurrentItem(1);

        //第二步：初始化Tablayout，给ViewPager设置标题（选项卡）
        tabLayout = (TabLayout) findViewById(R.id.tablayout);


        tabLayout.addTab(tabLayout.newTab().setText("最多人用"));//添加tab选项卡
        tabLayout.addTab(tabLayout.newTab().setText("为您推荐"));
        tabLayout.addTab(tabLayout.newTab().setText("部门在用"));

        //第三步：关联ViewPager
        tabLayout.setupWithViewPager(viewPager);


        //在关联ViewPager之后添加如下代码，前三步不用更改
        tabLayout.getTabAt(0).setText("最多人用");
        tabLayout.getTabAt(1).setText("为您推荐");
        tabLayout.getTabAt(2).setText("部门在用");


    }
    private void initData() {
        fragmentList.add(new Idledevices());
        fragmentList.add(new Atmostfragment());
        fragmentList.add(new RecommendFragment());
    }


}
