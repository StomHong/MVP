package com.stomhong.mvp.demo2;


import android.support.v4.app.Fragment;
import android.view.View;

import com.stomhong.mvp.R;
import com.stomhong.mvp.presenter.FragmentPresenter;


/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleFragment extends FragmentPresenter<SimpleFragmentDelegate> implements View.OnClickListener {

    @Override
    public Class<SimpleFragmentDelegate> getDelegateClass() {
        return SimpleFragmentDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        mViewDelegate.setOnClickListener(this, R.id.button2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button2:
                mViewDelegate.setText("您点了button");
                mViewDelegate.toast("您点了button");
                break;
        }
    }

}
