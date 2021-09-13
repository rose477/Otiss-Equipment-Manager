package com.hnucm18jr.devicemanage.Wo;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hnucm18jr.devicemanage.R;

import java.util.List;


public class TuijianAdapter extends BaseQuickAdapter<Tuijian, BaseViewHolder> {

    public TuijianAdapter(@LayoutRes int layoutResId, @Nullable List<Tuijian> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Tuijian item) {
        //可链式调用赋值
        helper.setText(R.id.num,  item.getNum() )
                .setText(R.id.user1,item.getUser())
                .setText(R.id.name, item.getName())
                .addOnClickListener(R.id.sc)
                .setImageResource(R.id.image, item.getImage());

        //获取当前条目position
        //int position = helper.getLayoutPosition();
    }
}
