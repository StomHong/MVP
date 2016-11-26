package com.stomhong.mvp.demo2;

import android.widget.TextView;

import com.stomhong.mvp.R;
import com.stomhong.mvp.view.AppDelegate;

/**
 * @author StomHong on 2016/11/26.
 */

public class SimpleFragmentDelegate extends AppDelegate {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_simple;
    }

    @Override
    public void initWidget() {
        super.initWidget();
        TextView textView = bindView(R.id.text2);
        textView.setText("在视图中创建代理");
    }

    public void setText(String text){
        TextView textView = get(R.id.text2);
        textView.setText(text);
    }

}
