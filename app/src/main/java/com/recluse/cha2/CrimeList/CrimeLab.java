package com.recluse.cha2.CrimeList;

import android.content.Context;

import com.recluse.cha2.Crime;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*
* 用于管理众多实体
* */


public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private List<Crime> mCrimes;

    //构造方法
    private CrimeLab(Context context){
        mCrimes=new ArrayList<>();
        for(int i=0;i<100;i++)
        {
            Crime crime=new Crime();
            crime.setTitle("Crime #"+i);
            crime.setSolved(i%2==0);
            mCrimes.add(crime);
        }
    }

    public static CrimeLab get(Context context)
    {
        if(sCrimeLab == null)
        {
            sCrimeLab=new CrimeLab(context);

        }
        return sCrimeLab;
    }

    /*
    *返回所有实例
    * */
    public List<Crime> getCrimes()
    {
        return mCrimes;
    }

    /*
    * 根据目标ID找目标实例
    * */
    public Crime getCrime(UUID id){
        for(Crime crime:mCrimes){
            if (crime.getId().equals(id))
            {
                return crime;
            }
        }
        return null;
    }

}
