package com.recluse.cha2.FragmentDemo;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.recluse.cha2.R;

public class DemoFragment extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //装载视图
        setContentView(R.layout.activity_fragment);
        FragmentManager manager=getSupportFragmentManager();
        //创建Fragment装人目标位置
        Fragment fragment =manager.findFragmentById(R.id.fragment_container);
        if(fragment==null) {
            fragment=new FragmentSEG();
            //通过manner创建Fragment
            manager.beginTransaction().add(R.id.fragment_container,fragment).commit();


        }


    }
}
