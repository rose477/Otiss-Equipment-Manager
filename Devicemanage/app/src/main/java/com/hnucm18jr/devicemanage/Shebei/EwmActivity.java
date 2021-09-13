package com.hnucm18jr.devicemanage.Shebei;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.hnucm18jr.devicemanage.R;

import java.util.Timer;
import java.util.TimerTask;

public class EwmActivity extends AppCompatActivity {
    private static final int START_ACITIVIY = 0X1;
    ImageView mImageView,mImageView2;
    ConstraintLayout mConstraintLayout3;
    private   Handler handler=new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case START_ACITIVIY:
                    showAlterDialog();

                    break;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        setContentView(R.layout.activity_ewm);
        mImageView=findViewById(R.id.back2);
        mImageView2=findViewById(R.id.main);
        mConstraintLayout3=findViewById(R.id.bg);


        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        handler.sendEmptyMessageDelayed(START_ACITIVIY,3000);






    }



    /**
     * 普通dialog
     */
    private void showAlterDialog(){
        final AlertDialog.Builder alterDiaglog = new AlertDialog.Builder(EwmActivity.this);
        alterDiaglog.setIcon(R.mipmap.headz);//图标
        alterDiaglog.setTitle("周小吕");//文字
        alterDiaglog.setMessage("唐小波您好，我可以借用您的雷蛇显示屏吗？");//提示消息
        //积极的选择

        alterDiaglog.setPositiveButton("同意", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(EwmActivity.this,"转借成功",Toast.LENGTH_SHORT).show();
                mImageView2.setImageResource(R.mipmap.demo2);
            }
        });
        //消极的选择
        alterDiaglog.setNegativeButton("拒绝", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(EwmActivity.this,"拒绝",Toast.LENGTH_SHORT).show();
            }
        });


        //显示
        alterDiaglog.show();
    }

}