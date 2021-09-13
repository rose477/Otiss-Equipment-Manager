package com.hnucm18jr.devicemanage.sao;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hnucm18jr.devicemanage.R;

import java.util.List;



public class Pj_adapter extends BaseQuickAdapter<Pj_sth, BaseViewHolder> {

    public Pj_adapter(@LayoutRes int layoutResId, @Nullable List<Pj_sth> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Pj_sth item) {
        //可链式调用赋值
        helper.setText(R.id.pj_name,  item.getName() )
                .setText(R.id.pj_time, item.getTime())
                .setText(R.id.pj_content, item.getContent())
                .setImageResource(R.id.pj_head, item.getHead());

        //获取当前条目position
        //int position = helper.getLayoutPosition();
    }
}
