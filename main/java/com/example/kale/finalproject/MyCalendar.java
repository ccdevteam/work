package com.example.kale.finalproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.Toast;

public class MyCalendar extends AppCompatActivity
{
    //data holders
    CalendarView calendar;

    private int Year;
    private int Month;
    private int Day;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_calendar);

        //Making Calendar View and setting change listener
        calendar = (CalendarView) findViewById(R.id.calendarView);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
        {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth)
            {
                setYear(year);
                setMonth(month);
                setDay(dayOfMonth);

                //printing the date that user picked
                Toast.makeText(getBaseContext(), "Selected date " + dayOfMonth
                        + "/" + month + "/" + year,Toast.LENGTH_LONG).show();
            }
        });

    }

    //Function that creates News button
    public void createSupriseButton()
    {
        //Creating New FloatingActionButton
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.main_action_button);

        //Creating an actual Floating Action Button
        com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton actionButton =
                new com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton.Builder(this)
                        .setContentView(imageView)
                        .build();
    }

    //Function that creates Weather Button
    public void createWeatherButton()
    {
        //Creating New FloatingActionButton
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.main_action_button);

        //Creating an actual Floating Action Button
        com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton actionButton =
                new com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton.Builder(this)
                        .setContentView(imageView)
                        .build();
    }

    //When News is clicked, open Google and search for news on
    //the date that user picked
    public void whatHappenedOnThisDay(View theButton)
    {
        Log.d("SearchDate", "Button Pressed");

        String whatHappendOn = "What happened on ";

        String googleSearchString =
                "https://www.google.com/search?q=" + whatHappendOn + getDay() + "/"
                + getMonth() + "/" + getYear();

        Intent searchWeb = new Intent(Intent.ACTION_VIEW,
                Uri.parse(googleSearchString));

        //start searching
        startActivity(searchWeb);
    }

    //When Weather is clicked, open Google and search for weather on
    //the date that user picked
    public void weatherForThisDay(View theButton)
    {
        Log.d("SearchDate", "Button Pressed");

        String weather = "Weather for ";

        String googleSearchString =
                "https://www.google.com/search?q=" + weather + getDay() + "/"
                        + getMonth() + "/" + getYear();

        Intent searchWeb = new Intent(Intent.ACTION_VIEW,
                Uri.parse(googleSearchString));

        //start searching
        startActivity(searchWeb);
    }

    //getters and setter for the date
    public int getYear()
    {
        return Year;
    }

    public int getMonth()
    {
        return Month;
    }

    public int getDay()
    {
        return Day;
    }

    public void setYear(int year)
    {
        Year = year;
    }

    public void setMonth(int month)
    {
        Month = month;
    }

    public void setDay(int day)
    {
        Day = day;
    }
}
