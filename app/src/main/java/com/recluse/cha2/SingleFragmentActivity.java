package com.recluse.cha2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/*
*抽象类
* 为了简化代码建立
* 只有一个Fragment的Activity可以继承该类
* 这样就可以用createFragment()来创建Activity视图
* */
public abstract class SingleFragmentActivity extends AppCompatActivity {
    //继承这个方法来生成对应的Fragment
    protected abstract Fragment createFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //装载最底层界面
        setContentView(R.layout.activity_fragment);//这是一个空白页面
        //管理Fragment，把他们的视图增加到视图层级结构
        FragmentManager fm=getSupportFragmentManager();
        //从队列里找到目标Fragment
        Fragment fragment=fm.findFragmentById(R.id.fragment_container);//
        //比如翻转屏幕，Fragment会被销毁，FragmentManager会保留Fragment队列，这时应新建Fragment增加到原有位置。
        if(fragment==null){
            fragment=createFragment();//这是一个抽象方法，需要后续继承
            //对Manager提交事务，第一个参数是容器，第二个参数是对象。
            fm.beginTransaction().add(R.id.fragment_container,fragment).commit();
        }

    }
}
