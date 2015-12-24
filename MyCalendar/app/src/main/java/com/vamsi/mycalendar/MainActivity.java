package com.vamsi.mycalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.vamsi.mycalendar.CustomCalendarView.CustomCalendar;
import com.vamsi.mycalendar.CustomCalendarView.Helpers.Badge;
import com.vamsi.mycalendar.CustomCalendarView.Helpers.CalenderDate;
import com.vamsi.mycalendar.CustomCalendarView.Helpers.ClickInterface;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);



        // intializing calendar view
        CustomCalendar calendar = (CustomCalendar) findViewById(R.id.view);


        //calendar view fits in full width of the screen.
        calendar.setFullScreenWidth(true);


        //adding badges to the dates.
        List<Badge> badges = new ArrayList<>();

        Badge badge = new Badge(2,11,12);//parameters: countOnBadge,dayOfMonth, Month as 1 to 12;

        badges.add(badge);
        badges.add(new Badge(1,2,11));
        badges.add(new Badge(3,26,12));
        badges.add(new Badge(2,24,2));

        calendar.setBadgeDateList(badges);

        // implementing onClickListener for dates.
        calendar.setOnClickDate(new ClickInterface() {
            @Override
            public void setDateClicked(CalenderDate date) {

                //displaying selected date in Toast (dd/mm/yyyy).
                Toast.makeText(MainActivity.this,""+date.getDay()+","+date.getMonth()+","+date.getYear(),Toast.LENGTH_LONG).show();

            }
        });




    }
}
