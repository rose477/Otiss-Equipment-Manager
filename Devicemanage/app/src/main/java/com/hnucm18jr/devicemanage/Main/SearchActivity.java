package com.hnucm18jr.devicemanage.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.hnucm18jr.devicemanage.R;
import com.hnucm18jr.devicemanage.Type.TypeActivity;

import org.xutils.BuildConfig;
import org.xutils.DbManager;
import org.xutils.ex.DbException;
import org.xutils.x;

public class SearchActivity extends AppCompatActivity {
    protected boolean useThemestatusBarColor = true;//是否使用特殊的标题栏背景颜色，android5.0以上可以设置状态栏背景色，如果不使用则使用透明色值
    protected boolean useStatusBarColor = false;//是否使用状态栏文字和图标为暗色，如果状态栏采用了白色系，则需要使状态栏和图标为暗色，android6.0以上可以设置
    TextView mTextView;
    EditText mEditText;

    Context mContext;
    AllsbFragment mAllsbFragment=new AllsbFragment();
    souFragment mSouFragment=new souFragment();
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mEditText=findViewById(R.id.edit);
        mEditText.setSelected(true);
        mEditText.requestFocus();//获得焦点
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,mSouFragment).commit();
        x.Ext.init(getApplication());
        x.Ext.setDebug(BuildConfig.DEBUG);// 是否输出debug日志, 开启debug会影响性能.
        x.view().inject(this);//没有用到view注解可以先不用

        mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    //添加搜索事件



                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,mAllsbFragment).commit();
                    if (mEditText.getText().toString().trim().length()!=0){
                        DbManager db = null;
                        try {
                            db = x.getDb(daoConfig);
                            Historysth user = new Historysth();
                            user.setHistory(mEditText.getText().toString());

                            db.save(user);
                        } catch (DbException e) {
                            e.printStackTrace();

                        }
                    }



                   
                          }

                return false;
            }
        });
        mTextView=findViewById(R.id.cancel);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setStatusBar();
    }
    /**
     * 隐藏软键盘
     */
    private static InputMethodManager manager;// 输入法管理器 用户隐藏软键盘

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