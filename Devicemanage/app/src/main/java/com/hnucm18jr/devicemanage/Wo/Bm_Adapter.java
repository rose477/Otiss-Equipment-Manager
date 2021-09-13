package com.hnucm18jr.devicemanage.Wo;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hnucm18jr.devicemanage.R;

import java.util.List;


public class Bm_Adapter extends BaseQuickAdapter<Bumen, BaseViewHolder> {

    public Bm_Adapter(@LayoutRes int layoutResId, @Nullable List<Bumen> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Bumen item) {
        //可链式调用赋值
        helper.setImageResource(R.id.image, R.drawable.a10);

        //获取当前条目position
        //int position = helper.getLayoutPosition();
    }
}
