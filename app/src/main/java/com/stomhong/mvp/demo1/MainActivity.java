package com.stomhong.mvp.demo1;

import android.view.View;

import com.stomhong.mvp.R;
import com.stomhong.mvp.presenter.ActivityPresenter;

public class MainActivity extends ActivityPresenter<MainActivityDelegate>implements View.OnClickListener{


    @Override
    public Class<MainActivityDelegate> getDelegateClass() {
        return MainActivityDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        mViewDelegate.setOnClickListener(this, R.id.button);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                mViewDelegate.setText("您点击了button");
                break;
        }
    }
}
