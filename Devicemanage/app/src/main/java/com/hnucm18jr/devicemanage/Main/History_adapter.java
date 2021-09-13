package com.hnucm18jr.devicemanage.Main;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hnucm18jr.devicemanage.R;

import java.util.List;


public class History_adapter extends BaseQuickAdapter<Historysth, BaseViewHolder> {

    public History_adapter(@LayoutRes int layoutResId, @Nullable List<Historysth> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Historysth item) {
        //可链式调用赋值
        helper.setText(R.id.hot_text, ""+ item.getHistory());



    }
}
