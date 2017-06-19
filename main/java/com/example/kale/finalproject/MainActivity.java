package com.example.kale.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{

    //Main Activity and Welcome Screen with floating button
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //When button is clicked go to next intent
    public void goToMyScheduleActivity(View theButton)
    {
        Log.d("MainActivity", "Button Pressed");

        Intent intent = new Intent(this, SecondActivity.class);

        startActivity(intent);
    }

    //function that creates welcome button
    public void createWelcomeButton()
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
