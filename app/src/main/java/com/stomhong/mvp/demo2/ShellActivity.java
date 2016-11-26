package com.stomhong.mvp.demo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.stomhong.mvp.R;

public class ShellActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shell);
        getSupportFragmentManager().beginTransaction().replace(R.id.content, new SimpleFragment())
                .commit();
    }
}
