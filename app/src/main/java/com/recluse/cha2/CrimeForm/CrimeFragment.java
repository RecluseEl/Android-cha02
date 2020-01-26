package com.recluse.cha2.CrimeForm;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.recluse.cha2.Crime;
import com.recluse.cha2.CrimeList.CrimeLab;
import com.recluse.cha2.R;

import java.util.UUID;

/*
* 表格的碎片，
* onCreateView方法用于动态的装载Fragment
* */
public class CrimeFragment extends Fragment{
    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;

    private static final String ARG_CRIME_ID="crime_id";
    /*fragment中可以绑定Bundle，Bundle是以键值对形式存储，每一个键值对称作一个argument*/
    /*该方法用于创建有Bundle的CrimeFragment*/
    public static CrimeFragment newInstance(UUID crimeId){
        /*创建Bundle，增加附加值*/
        Bundle args=new Bundle();
        args.putSerializable(ARG_CRIME_ID,crimeId);
        /*创建新的Fragment，把Bundle依附到Fragment*/
        CrimeFragment fragment=new CrimeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    //创建Crime实体，设置该实体的id
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //Intent中得到数据
        UUID crimeId=(UUID)getArguments().getSerializable(ARG_CRIME_ID);
        mCrime= CrimeLab.get(getActivity()).getCrime(crimeId);


    }
    //动态装载Fragment
    //这个方法创建一个视图并且返回
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        //生成视图（ID，父视图，是否把生成的视图传到父视图（false代码方式传递））
        View v= inflater.inflate(R.layout.fragment_crime,container,false);
        //装载Fragment的布局
        mTitleField=(EditText)v.findViewById(R.id.crime_title);
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mDateButton=(Button)v.findViewById(R.id.crime_date);
        mDateButton.setText(mCrime.getDate().toString());
        mDateButton.setEnabled(false);
        mSolvedCheckBox=(CheckBox)v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setSolved(isChecked);
            }
        });

        return v;


    }


}

