package com.hnucm18jr.devicemanage.sao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bigkoo.pickerview.TimePickerView;
import com.hnucm18jr.devicemanage.Main.SearchActivity;
import com.hnucm18jr.devicemanage.R;
import com.hnucm18jr.devicemanage.Shebei.EwmActivity;
import com.hnucm18jr.devicemanage.Shebei.XiuActivity;
import com.hnucm18jr.devicemanage.Wo.MyAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ShebeiActivity extends AppCompatActivity {
    protected boolean useThemestatusBarColor = true;//是否使用特殊的标题栏背景颜色，android5.0以上可以设置状态栏背景色，如果不使用则使用透明色值
    protected boolean useStatusBarColor = false;//是否使用状态栏文字和图标为暗色，如果状态栏采用了白色系，则需要使状态栏和图标为暗色，android6.0以上可以设置

    ImageView mImageView,mImageView2;
    Button mButton;
    Button mButton2;
    TextView mTextView;
    RecyclerView recyclerView;
    List<Zy_sth> datas;
    Zy_adapter adapter;
    RecyclerView recyclerView2;
    List<Pj_sth> datas2;
    Pj_adapter adapter2;
    TimePickerView pvTime;
    TextView mTextView2,mTextView3;
    ConstraintLayout mConstraintLayout,mConstraintLayout2,mConstraintLayout3;
    int i=0;
    private static final int START_ACITIVIY = 0X1;
    private Handler handler=new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case START_ACITIVIY:
                    notifition();

                    break;
            }

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shebei);
        mImageView=findViewById(R.id.back);
        mButton=findViewById(R.id.jie);
        mButton2=findViewById(R.id.huan);
        mTextView=findViewById(R.id.zt);
        mImageView2=findViewById(R.id.xiu);
        mTextView2=findViewById(R.id.user2);
        mTextView3=findViewById(R.id.time2);
        handler.sendEmptyMessageDelayed(START_ACITIVIY,3000);


        mTextView.setText("在用");
        mTextView.setTextColor(Color.parseColor("#D50000"));
        mTextView2.setText("周小吕在用");



        mImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ShebeiActivity.this, XiuActivity.class);
                startActivity(intent);
            }
        });
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(ShebeiActivity.this,"借用失败，请在规定范围内借用设备",Toast.LENGTH_SHORT).show();
               showAlterDialog();
           //     pvTime.show();

            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(ShebeiActivity.this,EndActivity.class);
               startActivity(intent);
            }
        });
        mConstraintLayout2=findViewById(R.id.m_out);
        mConstraintLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ShebeiActivity.this, EwmActivity.class);
                startActivity(intent);
            }
        });
        mConstraintLayout=findViewById(R.id.sc_out);
        mConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i==0){
                    mConstraintLayout.setSelected(true);
                    i++;
                }else {
                    mConstraintLayout.setSelected(false);
                    i--;
                }

            }
        });
        Zydata();
        Pjdata();
//        String s = getIntent().getStringExtra("key");
//        String s2 = getIntent().getStringExtra("key2");
      //  String s3 = getIntent().getStringExtra("key3");
//        mButton.setText(s);
//        mButton2.setText(s2);
       // mTextView.setText(s3);
//        if (s3.equals("空闲")){
//
//        }else {
//            mTextView.setTextColor(0xFFCD1010);
//        }

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setStatusBar();
        //控制时间范围(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
        //因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.set(2020, 0, 1);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2040, 11, 31);
        //时间选择器
        pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                // 这里回调的v,就是show()方法里面所添加的 View 参数，如果show的时候没有添加参数，v则为null
              //  mTextView3.setText(getTimes(date));

                Toast.makeText(ShebeiActivity.this,"已发送借用请求",Toast.LENGTH_SHORT).show();
                Log.i("click11","111"+getTimes(date));

            }
        })
                //年月日时分秒的显示与否，不设置则默认全部显示，这里可自行定制
                .setType(new boolean[]{true, true, true, true, true, false})
                .setLabel(" 年", "月", "日", "时", "分", "")
                .isCenterLabel(true)
                .setDividerColor(Color.DKGRAY)
                .setContentSize(15)
                .setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .setDecorView(null)
                .build();

    }
    private void notifition() {

//        Intent intent = new Intent(EwmActivity.this,NotificationActivity.class);
        //    PendingIntent pi = PendingIntent.getActivity(MainActivity.this,0,intent,0);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(ShebeiActivity.this)
                .setContentTitle("您的设备借用成功")  //设置标题
                .setContentText("对方已接受转借") //设置内容
                .setWhen(System.currentTimeMillis())  //设置时间
                .setSmallIcon(R.mipmap.notify)  //设置小图标  只能使用alpha图层的图片进行设置
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.headt))   //设置大图标

                //                       .setAutoCancel(true)
                .build();


        manager.notify(1,notification);

    }
    private void  showAlterDialog(){
        final AlertDialog.Builder alterDiaglog = new AlertDialog.Builder(ShebeiActivity.this);
        alterDiaglog.setIcon(R.mipmap.notify);//图标
        alterDiaglog.setTitle("提示");//文字
        alterDiaglog.setMessage("当前设备有人在用，请问需要继续向他借用吗？");//提示消息
        //积极的选择
        alterDiaglog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                pvTime.show();
                //Toast.makeText(ShebeiActivity.this,"请选择归还时间",Toast.LENGTH_SHORT).show();


            }
        });
        //消极的选择
        alterDiaglog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(ShebeiActivity.this,"取消",Toast.LENGTH_SHORT).show();
            }
        });


        //显示
        alterDiaglog.show();
    }
    private String getTimes(Date date) {//可根据需要自行格式化数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(date);
    }

    private void Pjdata() {
        recyclerView2=findViewById(R.id.pj_recycler);//实例化
        //模拟数据
        String a[]={"性能很好，体验感很好","真的很不错啊！！","每次用都觉得超赞的"};
        String b[]={"唐小波","周小吕","许小坚"};
        String c[]={"三分钟前","一天前","三天前"};
        int d[]={
                R.mipmap.headt, R.mipmap.headz, R.drawable.head,
        };
        datas2 = new ArrayList<>();
        Pj_sth pj_sth;
        for (int i = 0; i < 3; i++) {
            pj_sth= new Pj_sth();
            pj_sth.setTime(c[i]);
            pj_sth.setName(b[i]);
            pj_sth.setHead(d[i]);
            pj_sth.setContent(a[i]);
            datas2.add(pj_sth);


        }
        //创建布局管理
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView2.setLayoutManager(layoutManager);



        //创建适配器
        adapter2 = new Pj_adapter(R.layout.pj_item, datas2);

        //给RecyclerView设置适配器
        recyclerView2.setAdapter(adapter2);
        adapter2.notifyDataSetChanged();
    }

    private void Zydata() {
        recyclerView=findViewById(R.id.recycler_zy);//实例化

        //模拟数据
        datas = new ArrayList<>();
        String a[]={"性能很好，体验感很好","真的很不错啊！！","每次用都觉得超赞的"};
        String b[]={"唐小波","周小吕","许小坚"};
        String c[]={"三分钟前","一天前","三天前"};
        int d[]={
                R.mipmap.headt, R.mipmap.headz, R.drawable.head,
        };
        Zy_sth zy_sth;
        String  a2[]={"惠普台式电脑","惠普笔记本","惠普台式电脑","惠普台式电脑","惠普笔记本","惠普台式电脑"};
        int b2[]={
                R.drawable.diannao1,R.drawable.diannao2,R.drawable.diannao3,R.drawable.diannao4,R.drawable.diannao6,R.drawable.diannao7
        };
        String c2[]={"刘学友","张富城","周德华","罗斯","李多多","欧阳云海","欧皓辰"};
        String d2[]={"一小时","三十分钟","一天","三天","一天","两天","一个月"};
        for (int i = 0; i < 6; i++) {
            zy_sth= new Zy_sth();
            zy_sth.setTime(d2[i]+"后到期");
            zy_sth.setHead(b2[i]);
            zy_sth.setName(a2[i]);
            zy_sth.setUser(c2[i]+"在用");
            datas.add(zy_sth);


        }
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.HORIZONTAL));//可以表述一行显示item的数量，并且可以设置列表的方向


        //创建适配器
        adapter = new Zy_adapter(R.layout.zy_item, datas);

        //给RecyclerView设置适配器
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { //5.0以上
            View DecorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN //Activity全屏显示，且状态栏被覆盖掉
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;  //SYSTEM_UI_FLAG_LAYOUT_STABLE
            DecorView.setSystemUiVisibility(option);
            if (useThemestatusBarColor) {
                getWindow().setStatusBarColor(getResources().getColor(R.color.main));
            } else {
                getWindow().setStatusBarColor(Color.TRANSPARENT);
            }

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {  //44-5.0
            WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
            layoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | layoutParams.flags);  //状态栏透明
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !useStatusBarColor) {
            //6.0以上设置对文字状态栏设置为黑色，因为之前5.0我们设置为白色。
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

}