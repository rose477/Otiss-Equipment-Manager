package com.hnucm18jr.devicemanage.Main;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hnucm18jr.devicemanage.R;

import java.util.List;


public class Find_adapter extends BaseQuickAdapter<Hotsth, BaseViewHolder> {

    public Find_adapter(@LayoutRes int layoutResId, @Nullable List<Hotsth> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Hotsth item) {
        //可链式调用赋值
        helper.setText(R.id.hot_text, ""+ item.getHot() );


        //获取当前条目position
        //int position = helper.getLayoutPosition();
    }
}
