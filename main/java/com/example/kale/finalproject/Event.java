package com.example.kale.finalproject;

/**
 * This class is a Singleton and represents each
 * individual event that user puts in.
 */

public class Event
{
    //data holders
    private int id;
    private String eventName;
    private String eventDate;
    private String eventDescription;

    private static Event instance = null;

    //public constructor
    public Event() {}

    //Constructor
    public Event(int id, String eventName, String eventDate, String eventDescription)
    {
        this.id = id;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventDescription = eventDescription;
    }

    //singleton constructor
    public static Event getInstance()
    {
        if(instance == null)
        {
            instance = new Event();
        }
        return instance;
    }

    //Getters and Setters
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getEventName()
    {
        return eventName;
    }

    public void setEventName(String eventName)
    {
        this.eventName = eventName;
    }

    public String getEventDate()
    {
        return eventDate;
    }

    public void setEventDate(String eventDate)
    {
        this.eventDate = eventDate;
    }

    public String getEventDescription()
    {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription)
    {
        this.eventDescription = eventDescription;
    }
}
