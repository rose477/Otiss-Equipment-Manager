package com.hnucm18jr.devicemanage.Wo;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hnucm18jr.devicemanage.R;

import java.util.List;

public class MyAdapter extends BaseQuickAdapter<Shebei, BaseViewHolder> {

    public MyAdapter(@LayoutRes int layoutResId, @Nullable List<Shebei> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Shebei item) {
        //可链式调用赋值
        helper.setText(R.id.name, item.getName())
                .setText(R.id.time, item.getTime())
                .setImageResource(R.id.image, item.getImage());

        //获取当前条目position
        //int position = helper.getLayoutPosition();
    }
}
