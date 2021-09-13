package com.hnucm18jr.devicemanage.Shebei;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hnucm18jr.devicemanage.R;
import com.hnucm18jr.devicemanage.Zhuye;
import com.hnucm18jr.devicemanage.sao.ShebeiActivity;

import java.util.List;

public class SubclassAdapter extends BaseQuickAdapter<SubclassModel, BaseViewHolder> {
    int i=0;
    public SubclassAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId, data);
    }



    @Override
    protected void convert(BaseViewHolder helper, SubclassModel item) {
        TextView title = helper.getView(R.id.tv_title);
        title.setText(isStringNull(item.getTitle())?"":item.getTitle());

        helper.setText(R.id.tv_title, item.getTitle()).setText(R.id.tv_dsc, item.getDes()).setText(R.id.tv_author, item.getAuthor());
        helper.setImageResource(R.id.head,item.getImage());
        ConstraintLayout  constraintLayout=helper.getView(R.id.item);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), ShebeiActivity.class);
                v.getContext().startActivity(intent);
            }
        });
        final ImageView imageView=helper.getView(R.id.sc);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i==0){
                    imageView.setSelected(true);
                    i++;
                }else {
                    imageView.setSelected(false);
                    i--;
                }
            }
        });

    }

    /**
     * 判断字符串是否为null的方法
     */
    public static boolean isStringNull(String str) {
        return str == null || "".equals(str) || " ".equals(str) || "[]".equals(str) || str.length() == 0;
    }
}
