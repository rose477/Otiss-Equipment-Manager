package com.hnucm18jr.devicemanage.sao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.Float3;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import com.hnucm18jr.devicemanage.R;
import com.hnucm18jr.devicemanage.Shebei.EwmActivity;
import com.hnucm18jr.devicemanage.Shebei.FinishActivity3;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;

public class EndActivity extends AppCompatActivity {


    ImageView mImageView;
    Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }


        setContentView(R.layout.activity_end);
        mButton=findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EndActivity.this, FinishActivity3.class);
                startActivity(intent);
                finish();
            }
        });
        mImageView=findViewById(R.id.back);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        SimpleRatingBar rating = findViewById(R.id.rgb_ping);
        rating.setOnRatingBarChangeListener(new SimpleRatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(SimpleRatingBar simpleRatingBar, float rating, boolean fromUser) {

            }
        });
    }
}