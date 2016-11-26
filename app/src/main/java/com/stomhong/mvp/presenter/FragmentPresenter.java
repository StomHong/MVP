package com.stomhong.mvp.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stomhong.mvp.view.IDelegate;

/**
 * @author StomHong on 2016/11/26.
 */

public abstract class FragmentPresenter<T extends IDelegate> extends Fragment {

    protected T mViewDelegate;
    protected String TAG= FragmentPresenter.class.getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            mViewDelegate = getDelegateClass().newInstance();
//            TAG = getDelegateClass().getSimpleName();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Log.d(TAG,"onCreate.....................................");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        mViewDelegate.onCreate(inflater,container,savedInstanceState);
        Log.d(TAG,"onCreateView.....................................");
        return mViewDelegate.getRootView();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewDelegate.initWidget();
        bindEvenListener();
        Log.d(TAG,"onViewCreated.....................................");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (mViewDelegate == null){
            try {
                mViewDelegate = getDelegateClass().newInstance();
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG,"onViewStateRestored.....................................");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mViewDelegate = null;
        Log.d(TAG,"onDestroy.....................................");
    }

    protected void bindEvenListener() {

    }

    public abstract Class<T> getDelegateClass();


}
