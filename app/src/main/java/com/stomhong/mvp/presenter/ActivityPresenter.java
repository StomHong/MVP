package com.stomhong.mvp.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.stomhong.mvp.view.IDelegate;

/**
 * @author StomHong on 2016/11/26.
 */
public abstract class ActivityPresenter<T extends IDelegate> extends AppCompatActivity {

    protected T mViewDelegate;
    protected String TAG;

    public ActivityPresenter() {
        try {
            mViewDelegate = getDelegateClass().newInstance();//通过反射来获取具体代理类
            TAG = getDelegateClass().getSimpleName();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public abstract Class<T> getDelegateClass();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewDelegate.onCreate(getLayoutInflater(),null,savedInstanceState);
        setContentView(mViewDelegate.getRootView());
        mViewDelegate.initWidget();
        bindEvenListener();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (mViewDelegate == null){
            try {
                mViewDelegate = getDelegateClass().newInstance();
                mViewDelegate.onCreate(getLayoutInflater(),null,savedInstanceState);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewDelegate = null;
    }

    protected void bindEvenListener() {

    }
}
