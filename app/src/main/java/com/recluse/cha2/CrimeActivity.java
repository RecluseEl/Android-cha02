package com.recluse.cha2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CrimeActivity extends SingleFragmentActivity {

    /*
    * 布局文件复用
    * */
    @Override
    protected Fragment createFragment() {
        return new Fragment();
    }
}
