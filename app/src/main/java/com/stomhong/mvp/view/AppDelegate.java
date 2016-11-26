package com.stomhong.mvp.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * @author StomHong on 2016/11/26.
 */

public abstract class AppDelegate implements IDelegate {

    private View mRootView;
    private SparseArray<View> mViews = new SparseArray<>();//将View存起来

    @Override
    public void onCreate(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        mRootView = inflater.inflate(getLayoutId(), container, false);
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T bindView(@IdRes int id) {
        T view = (T) mViews.get(id);
        if (view == null) {
            view = (T) mRootView.findViewById(id);
            mViews.put(id, view);
        }
        return view;
    }

    public <T extends View> T get(@IdRes int id) {
        return bindView(id);
    }

    public void setOnClickListener(View.OnClickListener l, int... ids) {
        if (ids == null) {
            return;
        }
        for (int id : ids) {
            get(id).setOnClickListener(l);
        }
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    public void setRootView(View rootView) {
        this.mRootView = rootView;
    }

    @Override
    public void initWidget() {

    }

    /**
     * 获取布局的id
     * @return
     */
    public abstract int getLayoutId();

    public void toast(CharSequence msg) {
        Toast.makeText(mRootView.getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @SuppressWarnings("unchecked")
    public <T extends Activity> T getActivity() {
        return (T) mRootView.getContext();
    }

}
