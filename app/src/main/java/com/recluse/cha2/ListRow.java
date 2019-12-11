package com.recluse.cha2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
/*
* ViewHolder的工具类，用于容纳View视图
*
*
* */
public class ListRow extends RecyclerView.ViewHolder{
    public ImageView mThumbnail;

    public ListRow(View view) {
        super(view);
        mThumbnail=(ImageView)view.findViewById(R.id.thumbnail);


    }

}
