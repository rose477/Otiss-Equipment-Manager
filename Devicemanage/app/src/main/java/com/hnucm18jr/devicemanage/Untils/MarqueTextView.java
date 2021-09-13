package com.hnucm18jr.devicemanage.Untils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;


public class MarqueTextView extends androidx.appcompat.widget.AppCompatTextView {
    public MarqueTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    public MarqueTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public MarqueTextView(Context context) {
        super(context);
    }
    @Override
    public boolean isFocused() {
        //true表示获取焦点
        return true;
    }
}
