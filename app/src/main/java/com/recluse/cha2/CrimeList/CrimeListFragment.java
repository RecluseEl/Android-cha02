package com.recluse.cha2.CrimeList;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.recluse.cha2.Crime;
import com.recluse.cha2.R;

import java.util.List;

/*
* Recycler View 的主容器
*
* */
public class CrimeListFragment extends  Fragment{
    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //生成视图（ID，父视图，是否把生成的视图传到父视图（false代码方式传递））
        View view=inflater.inflate(R.layout.fragment_crime_list,container,false);
        mCrimeRecyclerView =(RecyclerView)view.findViewById(R.id.crime_recyclcler_view);//空白布局，用作容器
        updateUI();
        //若没有LayoutManager的支持，RecyclerView会无法工作，崩溃。LayoutManager摆放列表项和滚动
        //把RecyclerView 交给LayoutManager
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    private void updateUI() {
        CrimeLab crimeLab=CrimeLab.get(getActivity());
        List<Crime> crimes=crimeLab.getCrimes();
        mAdapter=new CrimeAdapter(crimes);
        mCrimeRecyclerView.setAdapter(mAdapter);
    }

    /*
    * 内部类，列表项
    * */
    private class CrimeHolder extends RecyclerView.ViewHolder{
        public CrimeHolder(LayoutInflater inflater,ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_crime,parent,false));
        }
    }

    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>
    {
        private List<Crime> mCrimes;

        public CrimeAdapter(List<Crime> crimes)
        {
            mCrimes=crimes;
        }

        @Override
        public CrimeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater layoutInflater=LayoutInflater.from(getActivity());
            return new CrimeHolder(layoutInflater,viewGroup);
        }

        @Override
        public void onBindViewHolder(@NonNull CrimeHolder crimeHolder, int i) {

        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }

}
