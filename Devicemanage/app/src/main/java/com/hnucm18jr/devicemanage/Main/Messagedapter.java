package com.hnucm18jr.devicemanage.Main;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hnucm18jr.devicemanage.R;

import java.util.List;


public class Messagedapter extends BaseQuickAdapter<Message, BaseViewHolder> {

    public Messagedapter(@LayoutRes int layoutResId, @Nullable List<Message> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Message item) {
        //可链式调用赋值
        helper.setText(R.id.pj_name, ""+ item.getName())
                .setText(R.id.content, ""+ item.getContent())
                .setText(R.id.agree, ""+ item.getAgree())

                .setText(R.id.refuse, ""+ item.getRefuse())
                .setText(R.id.pj_time,item.getTime())
                .addOnClickListener(R.id.agree)
                .setImageResource(R.id.head, item.getHead());

        ;



    }
}
