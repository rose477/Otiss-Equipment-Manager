package com.hnucm18jr.devicemanage.sao;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hnucm18jr.devicemanage.R;

import java.util.List;


public class Zy_adapter extends BaseQuickAdapter<Zy_sth, BaseViewHolder> {

    public Zy_adapter(@LayoutRes int layoutResId, @Nullable List<Zy_sth> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Zy_sth item) {
        //可链式调用赋值
        helper.setText(R.id.name_zy, item.getName() )
                .setText(R.id.time_zy, item.getTime())
                .setText(R.id.user_zy, item.getUser())
                .setImageResource(R.id.head_zy2,item.getHead());

        //获取当前条目position
        //int position = helper.getLayoutPosition();
    }
}
