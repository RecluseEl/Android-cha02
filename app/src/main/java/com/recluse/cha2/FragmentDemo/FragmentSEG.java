package com.recluse.cha2.FragmentDemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.recluse.cha2.R;

public class FragmentSEG extends android.support.v4.app.Fragment {
    TextView mTextView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_demo_fragment,container,false);
        mTextView=(TextView)view.findViewById(R.id.frag_text);
        return view;

    }
}
