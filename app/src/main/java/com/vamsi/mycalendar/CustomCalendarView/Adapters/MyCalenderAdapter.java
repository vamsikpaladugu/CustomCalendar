package com.vamsi.mycalendar.CustomCalendarView.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.vamsi.mycalendar.CustomCalendarView.CustomCalendar;
import com.vamsi.mycalendar.CustomCalendarView.Helpers.Badge;
import com.vamsi.mycalendar.CustomCalendarView.Helpers.CalenderDate;
import com.vamsi.mycalendar.R;

import java.util.List;

/**
 * Created by vamsi on 26/10/15.
 */

public class MyCalenderAdapter extends RecyclerView.Adapter<MyCalenderAdapter.ViewHolder> {

    Context context;
    int maxDay, firstDay, month, year, tDay;
    String[] day = {"Sun", "Mon", "Thu", "Wen", "Thr", "Fri", "Sat"};

    int cellSize = 50;

    List<Badge> badges;


    public MyCalenderAdapter(Context context, int maxDay, int firstDay, int month, int year, int tDay, int cellSize, List<Badge> badges) {

        this.context = context;
        this.maxDay = maxDay;
        this.firstDay = firstDay;
        this.month = month;
        this.year = year;
        this.tDay = tDay;
        this.cellSize = cellSize;
        this.badges = badges;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_calender_cell, parent, false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.tvBadge.setVisibility(View.GONE);


        if (position % 7 == 0)
            holder.tvDate.setTextColor(Color.RED);


        if (position < 7)
            holder.tvDate.setText("" + day[position]);

        else if (position > (7 + firstDay - 2)) {

            int toDay = (position - (7 + firstDay - 2));

            holder.tvDate.setText("" + toDay);

            for(int i=0;i<badges.size();i++){
                if(toDay == badges.get(i).getDay()){

                    holder.tvBadge.setText(""+badges.get(i).getCount());
                    holder.tvBadge.setVisibility(View.VISIBLE);

                }
            }



        } else {
            holder.tvDate.setText("");
        }


        holder.llCell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position > (7 + firstDay - 2)) {

                    int toDay = (position - (7 + firstDay - 2));

                    CalenderDate date = new CalenderDate();

                    date.setDay(toDay);
                    date.setMonth(month + 1);
                    date.setYear(year);


                    if (CustomCalendar.staticClickInterface() != null)
                        CustomCalendar.staticClickInterface().setDateClicked(date);
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return maxDay + 7 + firstDay - 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        protected TextView tvDate;
        protected TextView tvBadge;
        protected LinearLayout llCell;

        public ViewHolder(View view) {
            super(view);

            tvDate = (TextView) view.findViewById(R.id.tvDate);       //for date of month
            tvBadge = (TextView) view.findViewById(R.id.tvBadge);     //for badge on date
            llCell = (LinearLayout) view.findViewById(R.id.llCell);   //single date layout

            llCell.setLayoutParams(new LinearLayout.LayoutParams(cellSize, cellSize)); //adjusting width and height for single date layout

        }
    }

}

