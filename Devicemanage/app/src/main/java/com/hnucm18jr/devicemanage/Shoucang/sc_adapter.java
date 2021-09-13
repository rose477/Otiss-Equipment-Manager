package com.hnucm18jr.devicemanage.Shoucang;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hnucm18jr.devicemanage.R;
import com.hnucm18jr.devicemanage.Shebei.Wode_ragment;

import java.util.List;


public class sc_adapter extends BaseQuickAdapter<sc_sth, BaseViewHolder>  {

    public sc_adapter(@LayoutRes int layoutResId, @Nullable List<sc_sth> data) {
        super(layoutResId, data);
    }



    @Override
    protected void convert(BaseViewHolder helper, sc_sth item) {
        //可链式调用赋值
        helper.setText(R.id.num_sc,  item.getId() )
                .setText(R.id.id2,  item.getId2() )
                .setText(R.id.name, item.getName())
                .setText(R.id.type, item.getType())
                .setText(R.id.normal, item.getIsnormal())
                .setText(R.id.isuse, item.getIsuse())
                .addOnClickListener(R.id.button)
                .setImageResource(R.id.image2, item.getHead());

        //获取当前条目position
        //int position = helper.getLayoutPosition();
    }


}
