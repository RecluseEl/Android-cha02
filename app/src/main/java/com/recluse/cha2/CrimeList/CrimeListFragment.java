package com.recluse.cha2.CrimeList;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.AppCompatImageView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.recluse.cha2.Crime;
import com.recluse.cha2.CrimeForm.CrimeActivity;
import com.recluse.cha2.R;

import java.util.List;
import java.util.zip.Inflater;

/*
* RecyclerView 的主容器
*
* RecyclerView包含多个列表项（View)
*
* ViewHolder借助着itemView搭载着View
*
* ViewHolder由Adapter生成并且绑定数据
* */
public class CrimeListFragment extends Fragment{
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
        //构造Adapter
        mAdapter=new CrimeAdapter(crimes);
        //把Adapter绑定到RecyclerView
        mCrimeRecyclerView.setAdapter(mAdapter);
    }

    /*
    * 内部类，列表项
    * */
    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTitleTextView;
        private TextView mDateTextView;
        private TextView mSolvedImageView;
        private Crime mCrime;
        public CrimeHolder(LayoutInflater inflater,ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_crime,parent,false));
            mTitleTextView=(TextView)itemView.findViewById(R.id.crime_title);
            mDateTextView=(TextView)itemView.findViewById(R.id.crime_date);
            mSolvedImageView=(TextView) itemView.findViewById(R.id.crime_solved);
        }
        public void bind(Crime crime){
            mCrime=crime;
            mTitleTextView.setText(crime.getTitle());
            mDateTextView.setText(crime.getDate().toString());
            Log.d("demo", "bind: 1");
            if (crime.isSolved()==false) {
                mSolvedImageView.setVisibility(View.VISIBLE);
            }
            else mSolvedImageView.setVisibility(View.GONE);
            Log.d("demo", "bind: 2");
        }

        @Override
        public void onClick(View v) {
            Intent intent=CrimeActivity.newIntent(getActivity(),mCrime.getId());
            startActivity(intent);
        }

    }

    //Adapter 适配器
    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {
        //用于创建RecyclerView的实体
        private List<Crime> mCrimes;

        public CrimeAdapter(List<Crime> crimes)
        {
            mCrimes=crimes;
        }

        //CreateViewHolder
        @Override
        public CrimeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater layoutInflater=LayoutInflater.from(getActivity());
            return new CrimeHolder(layoutInflater,viewGroup);
        }

        //Bind Data to ViewHolder
        @Override
        public void onBindViewHolder(@NonNull CrimeHolder crimeHolder, int position) {
            Crime crime=mCrimes.get(position);
            crimeHolder.bind(crime);
        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }

}

