package com.recluse.cha2.CrimeForm;

import android.support.v4.app.Fragment;

import com.recluse.cha2.SingleFragmentActivity;


/*
*
* 表格Activity的入口
*
* */
public class CrimeActivity extends SingleFragmentActivity {

    /*
    * 布局文件复用
    * */
    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }

    //通过继承抽象类可以实现代码重复使用,所以注释掉
    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);//这是一个空白页面


        //管理Fragment，把他们的视图增加到视图层级结构
        FragmentManager fm=getSupportFragmentManager();
        //从队列里找到目标Fragment
        Fragment fragment=fm.findFragmentById(R.id.fragment_container);//
        //比如翻转屏幕，Fragment会被销毁，FragmentManager会保留Fragment队列，这时应新建Fragment增加到原有位置。
        if(fragment==null){
            fragment=new CrimeFragment();//创建CrimeFragment对象，实例中有动态装载的方法，所以可以引入Fragment
            //对Manager提交事务，第一个参数是容器，第二个参数是对象。
            fm.beginTransaction().add(R.id.fragment_container,fragment).commit();
        }

    }*/
}
