package com.hnucm18jr.devicemanage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.chaychan.library.BottomBarItem;
import com.chaychan.library.BottomBarLayout;

import com.hnucm18jr.devicemanage.Main.MessageActivity;
import com.hnucm18jr.devicemanage.Untils.CustomScrollViewPager;
import com.hnucm18jr.devicemanage.sao.ShebeiActivity;
import com.hnucm18jr.devicemanage.Main.Shebei_Fragment;
import com.hnucm18jr.devicemanage.Shoucang.Shoucang_Fragment;
import com.hnucm18jr.devicemanage.Shebei.Wode_ragment;
import com.hnucm18jr.devicemanage.sao.BlankFragment;
import com.hnucm18jr.devicemanage.Wo.Zhuye_Fragment;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.bean.ZxingConfig;
import com.yzq.zxinglibrary.common.Constant;

import java.util.ArrayList;
import java.util.List;

public class Zhuye extends AppCompatActivity {

    protected boolean useThemestatusBarColor = true;//是否使用特殊的标题栏背景颜色，android5.0以上可以设置状态栏背景色，如果不使用则使用透明色值
    protected boolean useStatusBarColor = false;//是否使用状态栏文字和图标为暗色，如果状态栏采用了白色系，则需要使状态栏和图标为暗色，android6.0以上可以设置
    CustomScrollViewPager mViewPager;
    BottomBarLayout mBottomBarLayout;
    List<Fragment> pageLists;
    BottomBarItem mBottomBarItem;
    ConstraintLayout mConstraintLayout;
    public  String account="002";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        setContentView(R.layout.activity_zhuye);
//        Intent intent=getIntent();
//        String account = intent.getStringExtra("account");

        mBottomBarLayout=findViewById(R.id.bbl);
        mViewPager=findViewById(R.id.vp_content);

        mBottomBarItem=findViewById(R.id.center);

        notifitation();
        Thread thread = new Thread(){//方法1
            @Override
            public void run() {
                super.run();
                //子线程
                initData();
            }
        };
        thread.start();


        mBottomBarItem.setOnClickListener(new View.OnClickListener() {//扫一扫
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(Zhuye.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
                    //请求权限
                    ActivityCompat.requestPermissions(Zhuye.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1);
                Intent intent = new Intent(Zhuye.this, CaptureActivity.class);
                ZxingConfig config = new ZxingConfig();
                config.setPlayBeep(true);//是否播放扫描声音 默认为true
                config.setShake(true);//是否震动  默认为true
                config.setDecodeBarCode(true);//是否扫描条形码 默认为true
                config.setReactColor(R.color.main);//设置扫描框四个角的颜色 默认为白色
                config.setFrameLineColor(R.color.touming);//设置扫描框边框颜色 默认无色
                config.setScanLineColor(R.color.main);//设置扫描线的颜色 默认白色
                config.setFullScreenScan(false);//是否全屏扫描  默认为true  设为false则只会在扫描框中扫描
                intent.putExtra(Constant.INTENT_ZXING_CONFIG, config);
                startActivityForResult(intent,111);
                onActivityResult(111,RESULT_OK,intent);
            }
        });


//        mConstraintLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//            }
//        });


    }

    private void notifitation() {
        Intent intent = new Intent(Zhuye.this, MessageActivity.class); //点击了之后进入的一个Actity
        PendingIntent pendingIntent = PendingIntent.getActivity(Zhuye.this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        Notification noti = new Notification.Builder(Zhuye.this)

                .setContentTitle("周小吕想借用您的惠普电脑")
                .setContentText("点击查看")
                .setWhen(System.currentTimeMillis())  //设置时间
                .setSmallIcon(R.mipmap.notify)//设置图标
                .setAutoCancel(true)//点击之后消失
                .setDefaults(Notification.DEFAULT_SOUND)//设置声音
                .setContentIntent(pendingIntent)//点击之后的页面
                .build();
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1,noti);//id控制第几条，相同的id会替换掉上一次的消息通知

    }

    private void initData() {
        pageLists=new ArrayList<>();//list里面fragment,
        pageLists.add(new Shebei_Fragment());
        pageLists.add(new Wode_ragment());


        pageLists.add(new BlankFragment());
        pageLists.add(new Shoucang_Fragment());
        pageLists.add(new Zhuye_Fragment());

        mViewPager.setAdapter(new fragmentAdapter(getSupportFragmentManager()));
        mBottomBarLayout.setViewPager(mViewPager);//底部bottombar;

    }
    /*
     *
     * viewpager适配器
     *
     * */
    public class fragmentAdapter extends FragmentPagerAdapter {
        public fragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return pageLists.get(position);
        }

        @Override
        public int getCount() {
            return pageLists.size();
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String content = data.getStringExtra(Constant.CODED_CONTENT);
        // 扫描二维码/条码回传
        if (requestCode == 111 && resultCode == RESULT_OK) {
            if (content != null) {



                Intent intent=new Intent(Zhuye.this, ShebeiActivity.class);
//                if (content.equals("1")){
//
//                    intent.putExtra("key","我想借");
//                    intent.putExtra("key2","我想还");
//                    intent.putExtra("key3","空闲");
//                }else if(content.equals("2")){
//                    intent.putExtra("key","我想还");
//                    intent.putExtra("key2","我想借");
//                    intent.putExtra("key3","已借出");
//                }else {
//                    intent.putExtra("key","找他借");
//                    intent.putExtra("key2","我想借");
//                    intent.putExtra("key3","已借出");
//                }

                startActivity(intent);
               
                //Intent intent = new Intent();
                //intent.setAction("android.intent.action.VIEW");
//                Uri content_url = Uri.parse(content);//此处填链接
//                intent.setData(content_url);
                //startActivity(intent);
            }
        }
    }



}