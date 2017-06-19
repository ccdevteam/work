package com.example.kale.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity
{
    //My second activity with two buttons for Calendar and My Schedule
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    //Go to My Schedule
    public void goToMyScheduleActivity(View theButton)
    {
        Log.d("MainActivity", "Button Pressed");

        Intent intent = new Intent(this, MySchedule.class);

        startActivity(intent);
    }

    //Go to My Calendar
    public void goToMyCalendarActivity(View theButton)
    {
        Log.d("MainActivity", "Button Pressed");

        Intent intent = new Intent(this, MyCalendar.class);

        startActivity(intent);
    }

    //Creating floating button
    public void createScheduleButton()
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

    //Creating floating button
    public void createCalendarButton()
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
}
