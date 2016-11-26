package com.stomhong.mvp.demo1;

import android.widget.TextView;

import com.stomhong.mvp.R;
import com.stomhong.mvp.view.AppDelegate;

/**
 * @author StomHong on 2016/11/26.
 */

public class MainActivityDelegate extends AppDelegate {
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initWidget() {
        super.initWidget();
        TextView textView = bindView(R.id.text);
        textView.setText("在视图中创建代理类");
    }

    public void setText(String text){
       TextView  textView =  get(R.id.text);
        textView.setText(text);
    }
}
