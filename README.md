# CustomCalendar
Android Project for CustomCalendarView with event badges.



![ScreenShot](https://cloud.githubusercontent.com/assets/15227330/11995652/51ac758a-aa7a-11e5-90aa-2d5d241c3d73.png)




##Usage

###### Include dependencie

``` 
dependencies {
    compile 'com.vamsi:customcalendar:1.0.0'
}
```

###### Include bellow code in your .xml

``` 
<com.vamsi.customcalendar.CustomCalendar
        android:id="@+id/view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:cellSize="80" />
```

###Customization

**CellSize**

- cellSize is a squre shaped size of each date cell in month. 
- The view is 7 cells wide and slightly more then 8 cells high.




**Intializing calendar view**
``` 
CustomCalendar calendar = (CustomCalendar) findViewById(R.id.view);
```

**Calendar view fits in full width of the screen**
``` 
calendar.setFullScreenWidth(true);
```

**Adding badges to the dates**
``` 
List<Badge> badges = new ArrayList<>();

Badge badge = new Badge(2,11,12);//parameters: countOnBadge,dayOfMonth, Month as 1 to 12;

badges.add(badge);
badges.add(new Badge(1,2,11));
badges.add(new Badge(3,26,12));
badges.add(new Badge(2,24,2));

calendar.setBadgeDateList(badges);

```

**Implementing onClickListener for dates.**
``` 
calendar.setOnClickDate(new ClickInterface() {
    @Override
    public void setDateClicked(CalenderDate date) {

      //displaying selected date in Toast (dd/mm/yyyy).
      Toast.makeText(MainActivity.this,""+date.getDay()+","+date.getMonth()+","+date.getYear(),Toast.LENGTH_LONG).show();

    }
});
```



