package com.hnucm18jr.devicemanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hnucm18jr.devicemanage.model.Login_;

import org.json.JSONException;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Login extends AppCompatActivity {

    EditText mEditText,mEditText2;
    Button mButton;
//    static String a;
//    static String b;
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }




        setContentView(R.layout.activity_main);
        mEditText=findViewById(R.id.right);
        mEditText2=findViewById(R.id.right2);
        mButton=findViewById(R.id.button);


        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mEditText.getText().toString().equals("202145") && mEditText2.getText().toString().equals("123456")){
                    Toast.makeText(Login.this,"登录成功",Toast.LENGTH_SHORT).show();


                    Intent intent=new Intent(Login.this, Zhuye.class);



                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(Login.this,"登录失败",Toast.LENGTH_SHORT).show();
                }
//
//                try {
//                    postAsynHttp();
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
            }
        });

    }
//    private void postAsynHttp() throws JSONException {//异步post的使用
//        a=mEditText.getText().toString();
//        b=mEditText2.getText().toString();
//        Log.i("post11",""+a+b);
//        HashMap<String,String> json=new HashMap<String, String>();
//        json.put("account",a);
//        json.put("pass",b);
//        Gson gson=new Gson();
//        String r=gson.toJson(json);
//        OkHttpClient mOkHttpClient = new OkHttpClient();
//        RequestBody requestBody = RequestBody.create(JSON, r);
//
//        Request request = new Request.Builder()
//                .url("http://192.168.43.138:8090/user/login")
//                .post(requestBody)
//                .build();
//        Call call = mOkHttpClient.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.i("fail","post失败"+e.getMessage());
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                final String str = response.body().string();
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Gson gson=new Gson();//创建Gson对象
//                        final Login_ login_=gson.fromJson(str,Login_.class);//第一个值传json数据，第二个值传解析的类型
//                        Log.i("post11",""+login_+str+a+b);
//
//                        if (a.equals(login_.getData().getAccount()) && b.equals(login_.getData().getPass())){
//                            Toast.makeText(Login.this,"登录成功",Toast.LENGTH_SHORT).show();
//
//
//                    Intent intent=new Intent(Login.this, Zhuye.class);
//                    intent.putExtra("account",login_.getData().getAccount());
//
//
//                    startActivity(intent);
//                        }else {
//                            Toast.makeText(Login.this,"登录失败",Toast.LENGTH_SHORT).show();
//                        }
//
//
//
//
//                    }
//                });
//            }
//        });
//    }

}