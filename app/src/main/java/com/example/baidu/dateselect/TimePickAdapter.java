package com.example.baidu.dateselect;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baidu on 2018/2/26.
 */

public class TimePickAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mDatas = new ArrayList<String>();
    static {
        Log.e("TimePickAdapter","s");
    }
    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.calendar_grid_item, null);
            TextView textView = convertView.findViewById(R.id.grid_item_tv);
            holder = new ViewHolder(textView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mTv.setText(mDatas.get(position));
        return convertView;
    }

    public TimePickAdapter(Context mContext, List<String> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    private class ViewHolder {
        private TextView mTv;

        public ViewHolder(TextView mTv) {
            this.mTv = mTv;
        }
    }
}
