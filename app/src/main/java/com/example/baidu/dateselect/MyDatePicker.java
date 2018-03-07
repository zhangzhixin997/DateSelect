package com.example.baidu.dateselect;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by zh on 2018/2/8.
 */

public class MyDatePicker extends LinearLayout implements View.OnClickListener {

    private List<String> mDatas = new ArrayList<String>();
    private GridView mDatalist;
    private Context mContext;
    private TimePickAdapter mAdapter;
    private int mWeekDay;
    private Calendar mCalendar;
    private int mYear;
    private int mMonth;
    private int mDay;
    private int mCountDays;
    private TextView mLeft;
    private TextView mRight;
    private TextView mCurrent;

    public MyDatePicker(Context context) {
        this(context, null);
    }

    public MyDatePicker(Context context,  AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyDatePicker(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        inflate(context, R.layout.time_choose_layout, this);
        initData();
        initView();
    }

    public void initView() {
        mDatalist = findViewById(R.id.data_list);
        mLeft = findViewById(R.id.left);
        mRight = findViewById(R.id.right);
        mCurrent = findViewById(R.id.current);
        mAdapter = new TimePickAdapter(mContext, mDatas);
        mDatalist.setAdapter(mAdapter);
        mCurrent.setText(mYear + "年-" + mMonth + "月");
        mLeft.setOnClickListener(this);
        mRight.setOnClickListener(this);
    }

    public void initData() {
        initDate();
        mDatas.clear();
        if(mWeekDay<7){
            for (int i = 0; i < mWeekDay; i++) {
                mDatas.add("");
            }
        }
        for (int i = 1; i <= mCountDays; i++) {
            mDatas.add(i + "");
        }
    }

    private void initDate() {
        if (mCalendar == null) {
            mCalendar = Calendar.getInstance();
        }
        mYear = mCalendar.get(Calendar.YEAR);
        mMonth = mCalendar.get(Calendar.MONTH) + 1;
        mDay = mCalendar.get(Calendar.DAY_OF_MONTH);
        mCountDays = mCalendar.getActualMaximum(Calendar.DATE);
        mWeekDay = getWeekDay();
    }

    private int getWeekDay() {
        mCalendar.set(Calendar.DAY_OF_MONTH, 0);
        return mCalendar.get(Calendar.DAY_OF_WEEK);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.left:
                mMonth -= 2;
                refreshList();
                refreshTitle();
                mAdapter.notifyDataSetChanged();

                break;
            case R.id.right:
                refreshList();
                refreshTitle();
                mAdapter.notifyDataSetChanged();
                break;
        }
    }

    private void refreshList() {
        if (mMonth < 0) {
            mMonth = 11;
            mYear--;
        } else if (mMonth > 12) {
            mYear++;
            mMonth = 0;
        }
        mCalendar.set(Calendar.YEAR, mYear);
        mCalendar.set(Calendar.MONTH, mMonth);
        mCalendar.set(Calendar.DAY_OF_MONTH, 1);
        initData();
    }

    private void refreshTitle() {
        mCurrent.setText(mYear + "年-" + mMonth + "月");
    }
}
