package com.hnucm18jr.devicemanage.Wo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.hnucm18jr.devicemanage.R;
import com.hnucm18jr.devicemanage.Shebei.FinishActivity;
import com.hnucm18jr.devicemanage.Shebei.XiuActivity;

public class BuyActivity extends AppCompatActivity {
    ImageView mImageView;
    Spinner mSpinner;
    Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_buy);
        mSpinner = findViewById(R.id.spinner_view);

        mImageView=findViewById(R.id.back);
        mButton=findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BuyActivity.this, Finish2Activity.class);
                startActivity(intent);
                finish();
            }
        });
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}