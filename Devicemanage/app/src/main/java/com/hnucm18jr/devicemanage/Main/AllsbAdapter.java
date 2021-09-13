package com.hnucm18jr.devicemanage.Main;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hnucm18jr.devicemanage.R;

import java.util.List;


public class AllsbAdapter extends BaseQuickAdapter<Allsb, BaseViewHolder> {

    public AllsbAdapter(@LayoutRes int layoutResId, @Nullable List<Allsb> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Allsb item) {
        //可链式调用赋值
        helper.setText(R.id.name,  item.getName())
                .setText(R.id.ues2, "空闲")
                .setText(R.id.zy, "普通设备")
                .setText(R.id.num, item.getNum())

                .setImageResource(R.id.imagehead, item.getImage());

        //获取当前条目position
        //int position = helper.getLayoutPosition();
    }
}
