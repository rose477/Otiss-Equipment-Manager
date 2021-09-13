package com.hnucm18jr.devicemanage.Shebei;

import android.graphics.Color;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hnucm18jr.devicemanage.R;

import java.util.List;

public class ClassifyAdapter extends BaseQuickAdapter<ClassifyModel, BaseViewHolder> {
    private int position;

    public ClassifyAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ClassifyModel item) {
        helper.setTextColor(R.id.tv_class_name, helper.getLayoutPosition() == position ? Color.parseColor("#036DDE") : Color.parseColor("#000000"));
        helper.setText(R.id.tv_class_name, item.getName());
    }

    public void setSelection(int pos) {
        this.position = pos;
        notifyDataSetChanged();
    }
}
