package com.example.kale.finalproject;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MySchedule extends AppCompatActivity implements View.OnClickListener
{
    //data holders
    private FloatingActionMenu actionMenu;
    private SubActionButton.Builder itemBuilder;

    private ListView lvEvent;
    private EventListAdapter adapter;
    private List<Event> mEventList;

    private static final String TAG_CALL = "call";
    private static final String TAG_GO = "go";
    private static final String TAG_DO = "do";

    private int Year;
    private int Month;
    private int Day;
    private int Hour;
    private int Minute;
    private String date;
    private String textInput;

    DateFormat formatDateTime = DateFormat.getDateTimeInstance();
    Calendar dateTime = Calendar.getInstance();
    DatePickerDialog dialog;
    TimePickerDialog timer;
    EditText input;

    private TextView nDisplayDate;
    private DatePickerDialog.OnDateSetListener nDateSetListener;

    List<String> eventOptions = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_schedule);

        //List View and array for my Events
        lvEvent = (ListView) findViewById(R.id.listView);
        mEventList = new ArrayList<>();

        //Setting that date to current date
        setYear(dateTime.get(Calendar.YEAR));
        setMonth(dateTime.get(Calendar.MONTH));
        setDay(dateTime.get(Calendar.DAY_OF_MONTH));

        //calling time, date, description dialogs
        timePicker();
        datePicker();
        descriptionInput();
        createButtonMenu();
    }

    public void createButtonMenu()
    {
        //Creating New FloatingActionButton
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.main_action_button);



        //Creating an actual Floating Action Button
        com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton actionButton =
                new com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton.Builder(this)
                        .setContentView(imageView)
                        .build();

        //Three sub buttons
        //User will have option to add a remider to call somebody
        //To text somebody or go somewhere
        //All the ImageResources that I am using are downloaded from:
        //http://www.freepik.com/free-icons
        ImageView call = new ImageView(this);
        call.setImageResource(R.drawable.call);

        ImageView go = new ImageView(this);
        go.setImageResource(R.drawable.go);

        ImageView todo = new ImageView(this);
        todo.setImageResource(R.drawable.todo);

        //Sub Action Button is used to build the menu around our main button
        itemBuilder = new SubActionButton.Builder(this);

        //Constructing menu items
        SubActionButton callSomebody = itemBuilder.setContentView(call).build();
        SubActionButton goSomewhere = itemBuilder.setContentView(go).build();
        SubActionButton doSomething = itemBuilder.setContentView(todo).build();

        //Adding click listeners to all three sub buttons
        callSomebody.setOnClickListener(this);
        goSomewhere.setOnClickListener(this);
        doSomething.setOnClickListener(this);

        //Setting tags so I can use it to check which button is clicked
        callSomebody.setTag(TAG_CALL);
        goSomewhere.setTag(TAG_GO);
        doSomething.setTag(TAG_DO);



        //Adding items to the menu
        actionMenu =  new FloatingActionMenu.Builder(this)
                .addSubActionView(callSomebody)
                .addSubActionView(goSomewhere)
                .addSubActionView(doSomething)
                .attachTo(actionButton)
                .build();

    }

    //This is what happens on each button click
    @Override
    public void onClick(View v)
    {

        if(v.getTag().equals(TAG_CALL))
        {

            timePicker();
            datePicker();
            descriptionInput();
            date = getDay() + "/" + getMonth() + "/" + getYear()
                    + ", " + getHour() + ":" + getMinute();
            mEventList.add(new Event(1, "CALL", date, textInput));

        }

        if(v.getTag().equals(TAG_GO))
        {
            timePicker();
            datePicker();
            descriptionInput();
            date = getDay() + "/" + getMonth() + "/" + getYear()
            + ", " + getHour() + ":" + getMinute();
            mEventList.add(new Event(1, "GO", date, textInput));

        }

        if(v.getTag().equals(TAG_DO))
        {
            timePicker();
            datePicker();
            descriptionInput();
            date = getDay() + "/" + getMonth() + "/" + getYear()
                    + ", " + getHour() + ":" + getMinute();
            mEventList.add(new Event(1, "DO", date, textInput));
            //eventOptions.add("DO");
        }

        //creating and actual adapter and setting it
        adapter = new EventListAdapter(getApplicationContext(), mEventList);
        lvEvent.setAdapter(adapter);

    }

    //Date picker dialog
    public void datePicker()
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(
                MySchedule.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                nDateSetListener,year,month,day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        nDateSetListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
            {
                month = month+1;
                setDay(dayOfMonth);
                setMonth(month);
                setYear(year);
            }
        };
    }

    //Description Dialog
    public void descriptionInput()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Event Details");
        builder.setIcon(R.drawable.button_action);
        builder.setMessage("What do you have to do?");

        input = new EditText(this);
        builder.setView(input);

        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                    textInput = input.getText().toString();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        final AlertDialog ad = builder.create();
        ad.show();
    }

    //time picker
    private void timePicker()
    {
        new TimePickerDialog(this, t, dateTime.get(Calendar.HOUR_OF_DAY), dateTime.get(Calendar.MINUTE), true).show();
    }

    TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            setHour(hourOfDay);
            setMinute(minute);
        }
    };

    //Getters and Setters for time and date
    public int getHour()
    {
        return Hour;
    }

    public void setHour(int hour)
    {
        Hour = hour;
    }

    public int getMinute()
    {
        return Minute;
    }

    public void setMinute(int minute)
    {
        Minute = minute;
    }

    public int getYear()
    {
        return Year;
    }

    public void setYear(int year)
    {
        Year = year;
    }

    public int getMonth()
    {
        return Month;
    }

    public void setMonth(int month)
    {
        Month = month;
    }

    public int getDay()
    {
        return Day;
    }

    public void setDay(int day)
    {
        Day = day;
    }
}
